package hu.bme.aut.stewe.rebrickableclient.interactor

import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.network.awaitResult
import hu.bme.aut.stewe.rebrickableclient.network.swagger.api.UsersApi
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.LegoSetsInSetList
import javax.inject.Inject

class SetDetailsInteractor : Interactor() {
    @Inject
    lateinit var usersApi: UsersApi

    init {
        injector.inject(this)
    }

    suspend fun getLegoSetDetails(id: Long): Result<LegoSetsInSetList> = runWithTokenCheck { token ->
        usersApi.usersSetlistsSetsList(id, token, 0, Int.MAX_VALUE, "asc").awaitResult()
    }
}
