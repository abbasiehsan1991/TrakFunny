package esi.app.trakfunny.daggercore.context

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import esi.app.trakfunny.daggercore.scope.ContextScope

@ContextScope
@Component
interface ContextComponent {

    fun provideApplication(): Application

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ContextComponent
    }

}