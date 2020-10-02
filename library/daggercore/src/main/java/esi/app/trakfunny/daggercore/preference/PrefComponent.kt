package esi.app.trakfunny.daggercore.preference

import dagger.Component
import esi.app.trakfunny.daggercore.context.ContextComponent
import esi.app.trakfunny.daggercore.scope.PrefScope

@PrefScope
@Component(
    dependencies = [ContextComponent::class],
    modules = [PreferenceModule::class]
)
interface PrefComponent {

}