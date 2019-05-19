package com.br.herbalistapp.persistence

import com.br.herbalistapp.LMSApplication

class LoginPersistence(val userName: String, val password: String) {

    fun save() {
        val editor = LMSApplication.getInstance().applicationContext
            .getSharedPreferences("STORAGE", 0)
            .edit()
        editor.putString(this.userName, this.password)
        editor.apply()
        println("save customer " + this)
    }

    fun find(): LoginPersistence {
        val prefs = LMSApplication.getInstance().applicationContext
            .getSharedPreferences("STORAGE", 0)
        val password = prefs.getString(this.userName, "")
        return LoginPersistence(this.userName, password)
    }

    override fun toString(): String {
        return "${this.userName}"
    }
}