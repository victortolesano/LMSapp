package com.br.herbalistapp.repository

import android.arch.persistence.room.*
import com.br.herbalistapp.persistence.UserPersistence

@Dao
interface UserRepository {

    @Query("SELECT * from user where cpf = :cpf")
    fun getByCpf(cpf: Int): UserPersistence?

    @Query("SELECT * from user")
    fun getAll(): List<UserPersistence>

    @Query("SELECT * FROM user WHERE syncd = 0")
    fun getUnsyncd(): List<UserPersistence>

    @Query("SELECT * FROM user WHERE name = :name AND password = :password")
    fun getByUsernameAndPassword(name: String, password: String): UserPersistence?

    @Query("SELECT MAX(ID) FROM user")
    fun getMaxID(): Long?

    @Insert
    fun insert(userPersistence: UserPersistence)

    @Delete
    fun delete(userPersistence: UserPersistence)

    @Update
    fun flagAsSynchronized(user: UserPersistence)
}