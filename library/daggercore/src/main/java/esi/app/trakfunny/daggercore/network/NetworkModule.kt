package esi.app.trakfunny.daggercore.network

import com.google.gson.Gson
import dagger.Lazy
import dagger.Module
import dagger.Provides
import esi.app.trakfunny.daggercore.scope.NetworkScope
import esi.app.trakfunny.data.repository.user.cloud.CloudUser
import esi.app.trakfunny.data.source.cloud.user.UserService
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@Module
object NetworkModule {

    @NetworkScope
    @Provides
    @JvmStatic
    fun providesOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
            //  .cache(cache)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        client.addNetworkInterceptor(interceptor)
        return client.build()
    }

    @Provides
    @JvmStatic
    fun providesRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        rxJava3CallAdapterFactory: RxJava3CallAdapterFactory,
        client: Lazy<OkHttpClient>
    ): Retrofit {
        return Retrofit.Builder().baseUrl("BuildConfig.API_BASE_URL")
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(rxJava3CallAdapterFactory)
            .callFactory(object : Call.Factory {
                override fun newCall(request: Request): Call {
                    return client.get().newCall(request)
                }
            })
            .build()
    }

    @Provides
    @JvmStatic
    fun providesGson(): Gson {
        return Gson()
    }

    @Provides
    @JvmStatic
    fun providesGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @JvmStatic
    fun providesRxJavaCallAdapterFactory(): RxJava3CallAdapterFactory {
        return RxJava3CallAdapterFactory.create()
    }
}