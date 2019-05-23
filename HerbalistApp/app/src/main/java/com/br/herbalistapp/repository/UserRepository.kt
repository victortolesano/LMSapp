package com.br.herbalistapp.repository

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.br.herbalistapp.persistence.UserPersistence

@Dao
interface UserRepository {

    @Query("SELECT * from user where cpf = :cpf")
    fun getByCpf(cpf: Int): UserPersistence?

    @Query("SELECT * from user")
    fun getAll(): List<UserPersistence>

    @Query("SELECT MAX(ID) FROM user")
    fun getMaxID(): Long?

    @Insert
    fun insert(userPersistence: UserPersistence)

    @Delete
    fun delete(userPersistence: UserPersistence)
}