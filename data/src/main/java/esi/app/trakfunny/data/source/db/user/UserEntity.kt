package esi.app.trakfunny.data.source.db.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity (
    @PrimaryKey
    val name:String
)