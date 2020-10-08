package esi.app.trakfunny.view.maincomponent

import dagger.Component
import esi.app.trakfunny.daggercore.builder.ViewModelBuilder
import esi.app.trakfunny.daggercore.network.NetComponent
import esi.app.trakfunny.daggercore.network.RepositoryBuilder
import esi.app.trakfunny.daggercore.scope.ActivityScope
import esi.app.trakfunny.mobile.view.MainActivity

@ActivityScope
@Component(dependencies = [NetComponent::class], modules = [RepositoryBuilder::class, ViewModelBuilder::class])
interface MainComponent {

    fun inject(activity: MainActivity)

}