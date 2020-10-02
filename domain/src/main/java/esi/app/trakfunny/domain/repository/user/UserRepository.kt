package esi.app.trakfunny.domain.repository.user

import io.reactivex.rxjava3.core.Single

interface UserRepository {
    fun getUser(localFirst: Boolean = false): Single<String>
}