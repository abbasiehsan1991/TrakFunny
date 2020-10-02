package esi.app.trakfunny.daggercore.network

import dagger.Binds
import dagger.Module
import esi.app.trakfunny.data.repository.UserRepositoryImp
import esi.app.trakfunny.domain.repository.user.UserRepository

@Module
abstract class RepositoryBuilder {

    @Binds
    abstract fun bindUserRepositoryImp(repoImp: UserRepositoryImp):UserRepository

}