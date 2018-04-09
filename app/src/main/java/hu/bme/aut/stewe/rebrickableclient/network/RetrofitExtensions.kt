package hu.bme.aut.stewe.rebrickableclient.network

import hu.bme.aut.stewe.rebrickableclient.CoroutineContexts
import kotlinx.coroutines.experimental.async
import retrofit2.Call
import retrofit2.HttpException

suspend fun <T> Call<T>.awaitResult(): Result<T> = async(CoroutineContexts.NETWORK) {
    try {
        val response = execute()

        if (response.isSuccessful) {
            Success(response.body()!!)
        } else {
            ServiceError<T>(HttpException(response))
        }
    } catch (e: Throwable) {
        NetworkException<T>(e)
    }
}.await()