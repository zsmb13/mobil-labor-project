package hu.bme.aut.stewe.rebrickableclient.ui.login

import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.interactor.*
import hu.bme.aut.stewe.rebrickableclient.launchAsync
import hu.bme.aut.stewe.rebrickableclient.ui.Presenter
import javax.inject.Inject


class LoginPresenter : Presenter<LoginScreen>() {

    @Inject
    lateinit var loginInteractor: LoginInteractor

    init {
        injector.inject(this)
    }

    fun login(username: String, password: String) = launchAsync {
        val result = loginInteractor.getUserToken(username, password)

        when (result) {
            is Success -> screen?.navigateToSetLists()
            is ServiceError -> screen?.showErrorMessage(result.error.message())
            is NetworkException -> screen?.showErrorMessage(result.exception.message!!)
            is DataSourceException -> screen?.showErrorMessage(result.exception.message!!)
        }
    }
}