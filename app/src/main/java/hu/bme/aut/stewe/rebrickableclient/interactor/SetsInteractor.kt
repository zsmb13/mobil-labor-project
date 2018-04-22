package hu.bme.aut.stewe.rebrickableclient.interactor

import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.network.awaitResult
import hu.bme.aut.stewe.rebrickableclient.network.swagger.api.UsersApi
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.LegoSetsInSetList
import javax.inject.Inject

class SetsInteractor : Interactor() {
    @Inject
    lateinit var usersApi: UsersApi

    init {
        injector.inject(this)
    }

    suspend fun getLegoSets(setListId: Long): Result<LegoSetsInSetList> = runWithTokenCheck { token ->
        usersApi.usersSetlistsSetsList(setListId, token, 0, Int.MAX_VALUE, "asc").awaitResult()
    }
}
