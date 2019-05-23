package com.br.herbalistapp.services

import android.content.Context
import com.br.herbalistapp.database.DatabaseManager
import com.br.herbalistapp.persistence.UserPersistence
import com.br.herbalistapp.utils.AndroidUtils
import com.google.gson.Gson
import com.google.gson.JsonObject
import java.net.URL
import kotlin.concurrent.thread

class UserService(val cpf: Long, val email: String, val name: String, val password: String) {

    val host = "https://elephantapi.herokuapp.com/"

    fun save(context: Context) {
        val dao = DatabaseManager.getUserRepository()
        if (AndroidUtils.isInternetDisponivel(context)) {
            val memoryUsers = dao.getAll()
            for (user in memoryUsers) {
                this.postAPI(user)
                dao.delete(user)
            }
            val userPersistence = UserPersistence()
            userPersistence.cpf = this.cpf
            userPersistence.email = this.email
            userPersistence.name = this.name
            userPersistence.password = this.password
            this.postAPI(userPersistence)
        } else {
            println("sem internet")
            val userPersistence = UserPersistence()
            userPersistence.id = this.nextID()
            userPersistence.cpf = this.cpf
            userPersistence.email = this.email
            userPersistence.name = this.name
            userPersistence.password = this.password
            dao.insert(userPersistence)
            println("usuario cadastrado")
            val result = dao.getAll()
            println(result)
        }
    }

    fun isValid(): Boolean {
        val url = "${this.host}users/${this.cpf}"
        val json = HttpHelper.get(url)
        val jsonObject = Gson().fromJson(json, JsonObject::class.java)
        val error = jsonObject.get("error").asString
        if (error.isEmpty() || error.isBlank()) {
            return true
        }
        return false
    }


    private fun postAPI(userPersistence: UserPersistence) {
        Thread {
            val json = JsonObject()
            json.addProperty("cpf", userPersistence.cpf)
            json.addProperty("name", userPersistence.name)
            json.addProperty("email", userPersistence.email)
            json.addProperty("password", userPersistence.password)
            HttpHelper.post("https://elephantapi.herokuapp.com/users", json.toString())
            println("usuario ${userPersistence.name} enviado para API")
        }.start()
    }

    private fun nextID(): Long {
        val dao = DatabaseManager.getUserRepository()
        val id = dao.getMaxID()
        if (id== null) {
            return 1
        }
        return id + 1
    }

}