package com.br.herbalistapp.services

import android.util.Log
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.io.IOException

object HttpHelper {
    private val TAG = "Herbalist"
    private val LOG_ON = true
    val JSON = MediaType.parse("application/json; charset=utf8")
    var client = OkHttpClient()

    //GET

    fun get(url:String):String{
        Log.d(TAG,"HttpHelper.get:,$url")
        val request = Request.Builder().url(url).get().build()
        return getJson(request)
    }

    //POS JSON
    fun post(url: String, json:String):String{
        Log.d(TAG,"HttpHelper.get:,$url > $json")
        val body = RequestBody.create(JSON,json)
        val request = Request.Builder().url(url).post(body).build()
        return getJson(request)
    }

    fun delete(url: String, json: String):String{
        val request = Request.Builder().url(url).delete().build()
        return getJson(request)
    }

    // le a resposta em formato JSON
    private fun getJson(request: Request?):String{
        val response = client.newCall(request).execute()
        val body = response.body()
        if (body != null){
            val json = body.string()
            Log.d(TAG,"<< : $json ")

            return json
        }
        throw IOException("ERRO NA REQUISIÇÃO")
    }
}