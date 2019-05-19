package com.br.herbalistapp.persistence

import android.content.SharedPreferences

import com.br.herbalistapp.LMSApplication

object Prefs {
    val PREF_ID = "LMS"

    // retorna o armazém de preferências PREF_ID
    fun prefs(): SharedPreferences {
        val context = LMSApplication.getInstance().applicationContext
        return context.getSharedPreferences(PREF_ID, 0)
    }

    fun setBoolean(flag: String, valor: Boolean) =  prefs().edit().putBoolean(flag, valor).apply()

    fun getBoolean(flag: String) = prefs().getBoolean(flag, false)

    fun setString(flag: String, valor: String) =  prefs().edit().putString(flag, valor).apply()

    fun getString(flag: String) = prefs().getString(flag, "")

}