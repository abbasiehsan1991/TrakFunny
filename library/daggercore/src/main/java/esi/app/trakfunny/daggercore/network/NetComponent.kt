package esi.app.trakfunny.daggercore.network

import dagger.Component
import esi.app.trakfunny.daggercore.context.ContextComponent
import esi.app.trakfunny.daggercore.scope.NetworkScope
import esi.app.trakfunny.data.repository.user.UserRepoModule
import esi.app.trakfunny.data.repository.user.cloud.CloudUser

@NetworkScope
@Component(
    dependencies = [ContextComponent::class],
    modules = [NetworkModule::class,UserRepoModule::class]
)
interface NetComponent {

    fun provideCloudUser(): CloudUser

}