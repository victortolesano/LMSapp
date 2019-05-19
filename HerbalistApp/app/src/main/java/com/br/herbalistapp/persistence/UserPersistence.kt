package com.br.herbalistapp.persistence

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "user")
class UserPersistence: Serializable {

    @PrimaryKey
    var id:Long = 0

    var cpf: Int = 0

    var email: String = ""

    var name: String = ""

    var password: String = ""
}