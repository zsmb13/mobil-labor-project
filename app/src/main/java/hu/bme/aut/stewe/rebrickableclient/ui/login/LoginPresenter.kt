package hu.bme.aut.stewe.rebrickableclient.ui.login

import hu.bme.aut.stewe.rebrickableclient.ui.Presenter
import javax.inject.Inject


class LoginPresenter : Presenter<LoginScreen>{

    @Inject
    lateinit var loginInteractor: LoginInteractor

    constructor(){

    }
}