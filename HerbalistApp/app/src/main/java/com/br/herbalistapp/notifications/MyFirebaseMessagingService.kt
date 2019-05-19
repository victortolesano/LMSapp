package com.br.herbalistapp.notifications

import android.content.Intent
import android.util.Log
import com.br.herbalistapp.MainActivity
import com.br.herbalistapp.R
import com.br.herbalistapp.persistence.Prefs
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    val TAG = "firebase boladão"
    val FIREBASE_TOKEN_KEY = "FB_TOKEN"

    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        Log.d(TAG, token)
        Prefs.setString(FIREBASE_TOKEN_KEY, token!!)
    }

    override fun onMessageReceived(message: RemoteMessage?) {
        Log.d(TAG, "onMessageReceived")

        if (message?.notification != null) {
            showNotification(message!!.notification!!, message?.data)
        }
    }

    private fun showNotification(notification: RemoteMessage.Notification, data: Map<String, String>?) {
        val intent = Intent(this, MainActivity::class.java)

        val title: String = notification.title ?: getString(R.string.app_name)
        var content = notification.body!!

        // e.g. assuming content = "%s (%s) acabou de se registrar"
        if (data != null && data!!.isNotEmpty()) {
            content = content.format(data!!["user"], data!!["cpf"])
        }

        NotificationUtil.create(this, 1, intent, title, content)
    }
}