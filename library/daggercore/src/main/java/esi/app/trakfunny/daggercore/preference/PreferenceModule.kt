package esi.app.trakfunny.daggercore.preference

import android.app.Application
import dagger.Module
import dagger.Provides
import esi.app.trakfunny.data.source.pref.PrefeKeys

@Module()
object PreferenceModule {

    @Provides
    @JvmStatic
    fun providePreferences(application: Application): PrefeKeys {
        return PrefeKeys(application)
    }

}