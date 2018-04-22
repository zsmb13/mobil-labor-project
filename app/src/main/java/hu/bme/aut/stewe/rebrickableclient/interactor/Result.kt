package hu.bme.aut.stewe.rebrickableclient.interactor

import retrofit2.HttpException

@Suppress("unused")
sealed class Result<T>

class Success<T>(
        val value: T
) : Result<T>()

class ServiceError<T>(
        val error: HttpException
) : Result<T>()

class NetworkException<T>(
        val exception: Throwable
) : Result<T>()

class DataSourceException<T>(
        val exception: Throwable
) : Result<T>()

class UserNotLoggedInException<T> : Result<T>()