package hu.bme.aut.stewe.rebrickableclient.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response


class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {
        val request = chain?.request()

        val newRequest: Request? = request?.newBuilder()
                ?.addHeader("Authorization", "key <auth_key>")
                ?.build()
        return if (newRequest != null) {
            chain.proceed(newRequest)!!
        } else {
            chain?.proceed(request)!!
        }
    }
}