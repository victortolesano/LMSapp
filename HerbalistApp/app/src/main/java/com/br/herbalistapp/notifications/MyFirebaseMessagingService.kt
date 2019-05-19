package com.br.herbalistapp.notifications

import android.util.Log
import com.br.herbalistapp.persistence.Prefs
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    val TAG = "firebase"
    val FIREBASE_TOKEN_KEY = "FB_TOKEN"

    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        Log.d(TAG, token)
        Prefs.setString(FIREBASE_TOKEN_KEY, token!!)
    }

    override fun onMessageReceived(message: RemoteMessage?) {
        Log.d(TAG, "onMessageReceived")

        if (message?.notification != null) {
            val title = message.notification?.title
            val body = message.notification?.body

            Log.d(TAG, title)
            Log.d(TAG, body)
        }
    }
}