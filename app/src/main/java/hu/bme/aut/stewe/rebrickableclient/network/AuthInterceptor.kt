package hu.bme.aut.stewe.rebrickableclient.network

import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.network.NetworkModule.RebrickableApiKey
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor : Interceptor {

    @Inject
    @RebrickableApiKey
    lateinit var apiKey: String

    init{
        injector.inject(this)
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request()
                .newBuilder()
                .addHeader("Authorization", "key $apiKey")
                .build()
        return chain.proceed(newRequest)
    }
}