package hu.bme.aut.stewe.rebrickableclient.interactor

import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.network.swagger.api.UsersApi
import javax.inject.Inject


class LoginInteractor {

    @Inject
    lateinit var usersApi: UsersApi

    init {
        injector.inject(this)
    }
}