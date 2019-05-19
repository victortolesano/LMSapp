package com.br.herbalistapp.persistence

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.br.herbalistapp.services.UserService
import java.io.Serializable

@Entity(tableName = "user")
class UserPersistence: Serializable {

    @PrimaryKey
    var id:Long = 0

    var cpf: Long = 0

    var email: String = ""

    var name: String = ""

    var password: String = ""

    /**
     * Synchronized: whether this `user` instance (row) is synchronized with the remote users server.
     * (0 or 1)
     */
    @ColumnInfo(name = "syncd")
    var syncd: Int = 0

    override fun toString(): String {
        return name + " (" + cpf + ")"
    }

    companion object {
        fun fromService(userService: UserService): UserPersistence {
            val up = UserPersistence()
            up.cpf = userService.cpf
            up.email = userService.email
            up.name = userService.name
            up.password = userService.password

            return up
        }
    }
}