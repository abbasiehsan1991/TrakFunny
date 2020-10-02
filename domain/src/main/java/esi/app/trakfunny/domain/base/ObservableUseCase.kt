package esi.app.trakfunny.domain.base

import io.reactivex.rxjava3.core.Observable


abstract class ObservableUseCase<T> {

    abstract fun execute(): Observable<T>

}