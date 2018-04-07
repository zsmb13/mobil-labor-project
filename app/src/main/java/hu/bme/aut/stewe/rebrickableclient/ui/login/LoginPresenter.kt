package hu.bme.aut.stewe.rebrickableclient.ui.login

import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.interactor.LoginInteractor
import hu.bme.aut.stewe.rebrickableclient.ui.Presenter
import javax.inject.Inject


class LoginPresenter : Presenter<LoginScreen>() {

    @Inject
    lateinit var loginInteractor: LoginInteractor

    init {
        injector.inject(this)
    }

    fun login(username: String, password: String) {
        // TODO get user token
    }

    private fun onLoginSuccess(setListCount: Int) {
        // TODO navigate to setlists screen
    }

    private fun onLoginFailed(message: String) {
        // TODO = screen?.showErrorMessage(message)
    }
}