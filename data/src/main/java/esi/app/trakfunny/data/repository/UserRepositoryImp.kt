package esi.app.trakfunny.data.repository

import esi.app.trakfunny.data.repository.user.cloud.CloudUser
import esi.app.trakfunny.data.repository.user.local.LocalUser
import esi.app.trakfunny.domain.repository.user.UserRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class UserRepositoryImp @Inject constructor(
    private val localUser: LocalUser,
    private val cloudUser: CloudUser
) : UserRepository {

    override fun getUser(localFirst: Boolean): Single<String> {
        TODO("Not yet implemented")
    }

}