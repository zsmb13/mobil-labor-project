package hu.bme.aut.stewe.rebrickableclient.network

import hu.bme.aut.stewe.rebrickableclient.asyncNetwork
import hu.bme.aut.stewe.rebrickableclient.interactor.NetworkException
import hu.bme.aut.stewe.rebrickableclient.interactor.Result
import hu.bme.aut.stewe.rebrickableclient.interactor.ServiceError
import hu.bme.aut.stewe.rebrickableclient.interactor.Success
import kotlinx.coroutines.experimental.Deferred
import retrofit2.Call
import retrofit2.HttpException

suspend fun <T> Call<T>.awaitResult(): Result<T> = this.getResultAsync().await()

suspend fun <T> Call<T>.getResultAsync() : Deferred<Result<T>> = asyncNetwork{
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
}