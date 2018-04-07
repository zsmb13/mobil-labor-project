package hu.bme.aut.stewe.rebrickableclient.interactor

import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.network.swagger.api.LegoApi
import javax.inject.Inject

class SetsInteractor {
    @Inject
    lateinit var legoApi: LegoApi

    init {
        injector.inject(this)
    }
}
