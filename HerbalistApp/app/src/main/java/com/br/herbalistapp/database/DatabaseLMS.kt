package com.br.herbalistapp.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.br.herbalistapp.persistence.UserPersistence
import com.br.herbalistapp.repository.UserRepository

@Database(entities = arrayOf(UserPersistence::class), version = 1)
abstract class DatabaseLMS: RoomDatabase() {

    abstract fun userRepository() : UserRepository
}