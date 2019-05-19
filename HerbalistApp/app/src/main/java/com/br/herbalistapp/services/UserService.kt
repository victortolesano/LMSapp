package com.br.herbalistapp.services

import android.content.Context
import com.br.herbalistapp.database.DatabaseManager
import com.br.herbalistapp.persistence.UserPersistence
import com.br.herbalistapp.utils.AndroidUtils
import com.google.gson.JsonObject

class UserService(val cpf: Long, val email: String, val name: String, val password: String) {


    fun save(context: Context): UserPersistence {
        val dao = DatabaseManager.getUserRepository()
        val userPersistence = UserPersistence.fromService(this)

        if (AndroidUtils.isInternetDisponivel(context)) {
            val memoryUsers = dao.getUnsyncd()
            for (user in memoryUsers) {
                this.postAPI(user)
                user.syncd = 1
                dao.flagAsSynchronized(user)
            }
            this.postAPI(userPersistence)
        } else {
            println("sem internet")
            userPersistence.id = this.nextID()
            dao.insert(userPersistence)
        }


        println("usuario cadastrado")
        val result = dao.getAll()
        println(result)


        return userPersistence
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