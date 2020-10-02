package esi.app.trakfunny.domain.usecase

import esi.app.trakfunny.domain.base.SingleUseCase
import esi.app.trakfunny.domain.repository.user.UserRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class SampleUseCase @Inject constructor(
    private val userRepository: UserRepository
) : SingleUseCase<String>() {

    override fun execute(): Single<String> {
        return userRepository.getUser()
    }

}