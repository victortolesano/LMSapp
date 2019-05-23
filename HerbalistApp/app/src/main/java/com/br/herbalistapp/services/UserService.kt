package com.br.herbalistapp.services

import android.content.Context
import com.br.herbalistapp.database.DatabaseManager
import com.br.herbalistapp.persistence.UserPersistence
import com.br.herbalistapp.utils.AndroidUtils

class UserService(val cpf: Int, val email: String, val name: String, val password: String) {


    fun save(context: Context) {
        val dao = DatabaseManager.getUserRepository()
        if (AndroidUtils.isInternetDisponivel(context)) {
            //TODO enviar instancia para API
            val memoryUsers = dao.getAll()
            for (user in memoryUsers) {
                this.memoryUserToApi(user)
                dao.delete(user)
            }
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


    private fun memoryUserToApi(userPersistence: UserPersistence) {
        println("enviando usuario ${userPersistence.name} para API")
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