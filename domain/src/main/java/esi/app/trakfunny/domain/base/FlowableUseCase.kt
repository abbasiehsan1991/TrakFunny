package esi.app.trakfunny.domain.base

import io.reactivex.rxjava3.core.Flowable

abstract class FlowableUseCase<T> {

    abstract fun execute(): Flowable<T>

}