package hu.bme.aut.stewe.rebrickableclient.interactor

import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.network.awaitResult
import hu.bme.aut.stewe.rebrickableclient.network.swagger.api.LegoApi
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.Theme
import javax.inject.Inject

class SetsInteractor : Interactor() {
    @Inject
    lateinit var legoApi: LegoApi

    init {
        injector.inject(this)
    }

    suspend fun getThemeInfo(id: Long): Result<Theme> =
            legoApi.legoThemesRead(id).awaitResult()
}
