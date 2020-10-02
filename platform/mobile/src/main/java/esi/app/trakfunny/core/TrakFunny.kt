package esi.app.trakfunny.core

import android.app.Application
import com.facebook.stetho.Stetho
import esi.app.trakfunny.daggercore.context.DaggerContextComponent
import esi.app.trakfunny.daggercore.core.CoreComponent
import esi.app.trakfunny.daggercore.core.CoreComponentProvider
import esi.app.trakfunny.daggercore.core.DaggerCoreComponent
import esi.app.trakfunny.daggercore.database.DaggerDatabaseComponent
import esi.app.trakfunny.daggercore.network.DaggerNetComponent
import esi.app.trakfunny.daggercore.preference.DaggerPrefComponent

class TrakFunny : Application(),
    CoreComponentProvider {

    lateinit var core: CoreComponent

    override fun onCreate() {
        super.onCreate()

        val context = DaggerContextComponent.factory().create(this)
        val database = DaggerDatabaseComponent.builder().contextComponent(context).build()
        val pref = DaggerPrefComponent.builder().contextComponent(context).build()
        val net = DaggerNetComponent.builder().contextComponent(context).build()
        core = DaggerCoreComponent
            .factory()
            .create(context, database, pref, net)
            .also {
                it.inject(this)
            }

        Stetho.initializeWithDefaults(this)
    }

    override fun getCoreComponent(): CoreComponent {
        return core
    }
}