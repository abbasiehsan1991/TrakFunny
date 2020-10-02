package esi.app.trakfunny.daggercore.core

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import esi.app.trakfunny.daggercore.context.ContextComponent
import esi.app.trakfunny.daggercore.database.DatabaseComponent
import esi.app.trakfunny.daggercore.network.NetComponent
import esi.app.trakfunny.daggercore.preference.PrefComponent
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
    ]
)
interface CoreComponent {

    fun provideContextComponent(): ContextComponent
    fun provideDatabaseComponent(): DatabaseComponent
    fun providePrefComponent(): PrefComponent
    fun provideNetComponent(): NetComponent


    fun inject(application: Application)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance contextComponent: ContextComponent,
            @BindsInstance databaseComponent: DatabaseComponent,
            @BindsInstance prefComponent: PrefComponent,
            @BindsInstance netComponent: NetComponent
        ): CoreComponent
    }

}
