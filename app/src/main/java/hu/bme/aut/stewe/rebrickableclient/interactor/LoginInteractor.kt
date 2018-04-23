package hu.bme.aut.stewe.rebrickableclient.interactor

import hu.bme.aut.stewe.rebrickableclient.asyncRepository
import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.network.awaitResult
import hu.bme.aut.stewe.rebrickableclient.network.swagger.api.UsersApi
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.UserToken
import javax.inject.Inject


class LoginInteractor : Interactor() {

    @Inject
    lateinit var usersApi: UsersApi

    init {
        injector.inject(this)
    }

    suspend fun getUserToken(username: String, password: String): Result<UserToken> {
        val storedToken = getUserTokenFromRepository()
        return if (storedToken == null) {
            val result = usersApi.usersTokenCreate(username, password).awaitResult()
            if (result is Success) {
                asyncRepository { repository.userTokenData().saveUserToken(result.value.userToken!!) }
            }
            result
        } else {
            Success(UserToken(userToken = storedToken))
        }
    }
}