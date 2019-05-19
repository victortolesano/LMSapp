package com.br.herbalistapp.persistence

import com.br.herbalistapp.LMSApplication

class LoginPersistence(val userName: String, val password: String) {

    fun save() {
        val editor = LMSApplication.getInstance().applicationContext
            .getSharedPreferences("STORAGE", 0)
            .edit()
        editor.putString("usuario", this.userName)
        editor.apply()
        println("===========================================")
        println("save user " + this)
        println("===========================================")
    }

    fun find(): LoginPersistence? {
        val prefs = LMSApplication.getInstance().applicationContext
            .getSharedPreferences("STORAGE", 0)
        val userName = prefs.getString("usuario", "")
        if (userName.isBlank()) {
            return null
        }
        return LoginPersistence(userName, "")
    }

    fun delete() {
        val editor = LMSApplication.getInstance().applicationContext
            .getSharedPreferences("STORAGE", 0)
            .edit()
        editor.remove("usuario").apply()
    }

    override fun toString(): String {
        return "${this.userName}"
    }
}