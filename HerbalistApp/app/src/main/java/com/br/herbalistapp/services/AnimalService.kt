package com.br.herbalistapp.services

import android.content.Context
import android.util.JsonReader
import android.util.Log
import com.br.herbalistapp.domain.Animal
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.net.URL

object AnimalService {
    val host = "https://elephantapi.herokuapp.com/"
    val TAG = "USUARIO"
    fun getUsuario(context: Context): List<Animal>{
        val url = "$host/users/12345678921"
        val json = URL(url).readText()
        Log.d(TAG,json)

        return parserJson(json)

    }

    inline fun <reified T> parserJson(json:String) : T{
        val type = object : TypeToken<T>() {}.type
        return Gson().fromJson<T>(json,type)
    }
//    fun getAnimals(context: Context): List<Animal> {
//        return (1..10).map { Animal("kitty", "kitty kat", "http") }
//    }
}