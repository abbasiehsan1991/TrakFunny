package esi.app.trakfunny.daggercore.database

import android.app.Application
import androidx.room.Room
import esi.app.trakfunny.data.source.db.TrakFunnyDatabase
import dagger.Module
import dagger.Provides
import esi.app.trakfunny.daggercore.scope.DatabaseScope

@Module()
object DatabaseModule {

    @DatabaseScope
    @Provides
    @JvmStatic
    fun provideAppDatabase(application: Application): TrakFunnyDatabase {

        return Room
            .databaseBuilder(application, TrakFunnyDatabase::class.java, TrakFunnyDatabase.APP_DATABASE_NAME)
            .build()
    }

}