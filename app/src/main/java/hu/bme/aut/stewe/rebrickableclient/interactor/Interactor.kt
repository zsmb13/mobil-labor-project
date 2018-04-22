package hu.bme.aut.stewe.rebrickableclient.interactor

import hu.bme.aut.stewe.rebrickableclient.asyncRepository
import hu.bme.aut.stewe.rebrickableclient.repository.Repository
import javax.inject.Inject

abstract class Interactor {
    @Inject
    lateinit var repository: Repository

    protected suspend fun <T> runWithTokenCheck(block: suspend (String) -> Result<T>) = try {
        val token = getUserTokenFromRepository()
        if (token == null) {
            UserNotLoggedInException()
        } else {
            block(token)
        }
    } catch (e: Exception) {
        DataSourceException<T>(e)
    }

    protected suspend fun getUserTokenFromRepository() = asyncRepository { repository.userTokenData().getUserToken() }.await()

    suspend fun deleteUserTokenFromRepository() = asyncRepository { repository.userTokenData().deleteUserToken() }.await()
}