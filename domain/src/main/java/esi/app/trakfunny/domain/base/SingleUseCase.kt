package esi.app.trakfunny.domain.base

import io.reactivex.rxjava3.core.Single

abstract class SingleUseCase<T> {

    abstract fun execute(): Single<T>

}