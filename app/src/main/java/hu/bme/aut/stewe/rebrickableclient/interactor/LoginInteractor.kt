package hu.bme.aut.stewe.rebrickableclient.interactor

import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.network.awaitResult
import hu.bme.aut.stewe.rebrickableclient.network.swagger.api.UsersApi
import javax.inject.Inject


class LoginInteractor {

    @Inject
    lateinit var usersApi: UsersApi

    var userToken: String? = null

    init {
        injector.inject(this)
    }

    suspend fun getUserToken(username: String, password: String) =
            usersApi.usersTokenCreate(username, password).awaitResult()


    suspend fun getUserSetListCount() =
            usersApi.usersSetlistsList(userToken!!, 0, Integer.MAX_VALUE).awaitResult()

    suspend fun storeToken(token: String) {
        userToken = token
    }

    private suspend fun getUserToken() = userToken
}