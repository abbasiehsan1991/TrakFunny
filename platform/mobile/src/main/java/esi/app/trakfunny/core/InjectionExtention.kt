package esi.app.trakfunny.core

import android.content.Context
import esi.app.trakfunny.daggercore.core.CoreComponent
import esi.app.trakfunny.daggercore.core.CoreComponentProvider

fun Context.findCoreComponent(): CoreComponent =
    (applicationContext as? CoreComponentProvider)?.getCoreComponent()
        ?: throw Throwable("Your application class must be implemented CoreComponentProvider interface!!!")
