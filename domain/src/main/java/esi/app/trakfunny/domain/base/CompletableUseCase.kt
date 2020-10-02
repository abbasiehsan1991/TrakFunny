package esi.app.trakfunny.domain.base

import io.reactivex.rxjava3.core.Completable


abstract class CompletableUseCase {

    abstract fun execute(): Completable

}