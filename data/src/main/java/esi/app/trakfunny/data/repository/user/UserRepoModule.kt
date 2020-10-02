package esi.app.trakfunny.data.repository.user

import dagger.Binds
import dagger.Module
import dagger.Provides
import esi.app.trakfunny.data.repository.user.cloud.CloudUser
import esi.app.trakfunny.data.repository.user.cloud.CloudUserImp
import esi.app.trakfunny.data.repository.user.local.LocalUser
import esi.app.trakfunny.data.repository.user.local.LocalUserImp
import esi.app.trakfunny.data.source.cloud.user.UserService
import retrofit2.Retrofit

@Module
abstract class UserRepoModule {

    @Binds
    abstract fun bindLocalUser(localUserImp: LocalUserImp): LocalUser

    @Binds
    abstract fun bindCloudUser(cloudUserImp: CloudUserImp): CloudUser

    companion object {
        @Provides
        @JvmStatic
        fun provideService(retrofit: Retrofit): UserService {
            return retrofit.create(UserService::class.java)
        }
    }
}