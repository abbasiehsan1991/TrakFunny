package esi.app.trakfunny.data.source.cloud.user

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET


interface UserService {

    @GET("profile")
    fun getUser(): Single<String>
}