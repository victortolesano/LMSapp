package com.br.herbalistapp.database

import android.arch.persistence.room.Room
import android.arch.persistence.room.migration.Migration
import com.br.herbalistapp.LMSApplication
import com.br.herbalistapp.database.migrations.Migrations
import com.br.herbalistapp.repository.UserRepository

object DatabaseManager {

    private var dbInstance: DatabaseLMS
    init {
        val appContext = LMSApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            appContext,
            DatabaseLMS::class.java,
            "lms.sqlite"
        ).addMigrations(Migrations.MIGRATION_1_2).build()
    }

    fun getUserRepository(): UserRepository{
        return dbInstance.userRepository()
    }
}