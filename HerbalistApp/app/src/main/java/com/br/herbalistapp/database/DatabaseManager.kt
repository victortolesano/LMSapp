package com.br.herbalistapp.database

import android.arch.persistence.room.Room
import com.br.herbalistapp.LMSApplication
import com.br.herbalistapp.repository.UserRepository

object DatabaseManager {

    private var dbInstance: DatabaseLMS
    init {
        val appContext = LMSApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            appContext,
            DatabaseLMS::class.java,
            "lms.sqlite"
        ).allowMainThreadQueries().build()
    }

    fun getUserRepository(): UserRepository{
        return dbInstance.userRepository()
    }
}