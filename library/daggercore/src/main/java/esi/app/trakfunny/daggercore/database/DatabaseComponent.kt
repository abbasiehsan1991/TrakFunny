package esi.app.trakfunny.daggercore.database

import dagger.Component
import esi.app.trakfunny.daggercore.context.ContextComponent
import esi.app.trakfunny.daggercore.scope.DatabaseScope

@DatabaseScope
@Component(
    dependencies = [ContextComponent::class],
    modules = [DatabaseModule::class]
)
interface DatabaseComponent {

}