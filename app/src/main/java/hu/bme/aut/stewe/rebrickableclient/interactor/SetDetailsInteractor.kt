package hu.bme.aut.stewe.rebrickableclient.interactor

import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.network.awaitResult
import hu.bme.aut.stewe.rebrickableclient.network.swagger.api.LegoApi
import hu.bme.aut.stewe.rebrickableclient.network.swagger.api.UsersApi
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.SetListLegoSet
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.Theme
import javax.inject.Inject

class SetDetailsInteractor : Interactor() {
    @Inject
    lateinit var usersApi: UsersApi

    @Inject
    lateinit var legoApi: LegoApi

    init {
        injector.inject(this)
    }

    suspend fun getLegoSetDetails(id: String): Result<SetListLegoSet> = runWithTokenCheck { token ->
        usersApi.usersSetsRead(id, token).awaitResult()
    }

    suspend fun getThemeInfo(id: Long): Result<Theme> =
            legoApi.legoThemesRead(id).awaitResult()
}
