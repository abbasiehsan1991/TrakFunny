package esi.app.trakfunny.data.source.db

import androidx.room.Database
import androidx.room.RoomDatabase
import esi.app.trakfunny.data.source.db.user.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class TrakFunnyDatabase : RoomDatabase() {

    companion object {
        const val APP_DATABASE_NAME= "TrakFunny.db"
    }
}
