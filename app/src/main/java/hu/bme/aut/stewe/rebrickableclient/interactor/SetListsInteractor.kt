package hu.bme.aut.stewe.rebrickableclient.interactor

import hu.bme.aut.stewe.rebrickableclient.asyncRepository
import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.network.awaitResult
import hu.bme.aut.stewe.rebrickableclient.network.swagger.api.UsersApi
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.SetLists
import javax.inject.Inject

class SetListsInteractor : Interactor() {

    @Inject
    lateinit var usersApi: UsersApi

    init {
        injector.inject(this)
    }

    suspend fun getUserSetLists(): Result<SetLists> = runWithTokenCheck { token ->
        val result = usersApi.usersSetlistsList(token, 1, Integer.MAX_VALUE).awaitResult()
        if (result is Success) {
            asyncRepository {
                repository.setListData().insertAll(*result.value.results.toTypedArray())
            }.await()
        }
        result
    }

}
