package hu.bme.aut.stewe.rebrickableclient.interactor

import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.network.Result
import hu.bme.aut.stewe.rebrickableclient.network.awaitResult
import hu.bme.aut.stewe.rebrickableclient.network.swagger.api.UsersApi
import hu.bme.aut.stewe.rebrickableclient.network.swagger.dto.UserToken
import javax.inject.Inject


class LoginInteractor {

    @Inject
    lateinit var usersApi: UsersApi

    init {
        injector.inject(this)
    }

    suspend fun getUserToken(): Result<UserToken> =
            usersApi.usersTokenCreate("SteweMetal", "STWmetal13")
                    .awaitResult()


}