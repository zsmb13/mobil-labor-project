package hu.bme.aut.stewe.rebrickableclient.ui.login

import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.interactor.LoginInteractor
import hu.bme.aut.stewe.rebrickableclient.network.NetworkException
import hu.bme.aut.stewe.rebrickableclient.network.ServiceError
import hu.bme.aut.stewe.rebrickableclient.network.Success
import hu.bme.aut.stewe.rebrickableclient.ui.Presenter
import kotlinx.coroutines.experimental.runBlocking
import javax.inject.Inject


class LoginPresenter : Presenter<LoginScreen>() {
    @Inject
    lateinit var loginInteractor: LoginInteractor

    init {
        injector.inject(this)
    }


    fun tryLogin() = runBlocking {
        var result = loginInteractor.getUserToken()
        when(result) {
            is Success -> screen?.showErrorMessage(result.value.token)
            is ServiceError -> screen?.showErrorMessage(result.error.message())
            is NetworkException -> screen?.showErrorMessage(result.exception.message!!)
        }
    }


    private fun onLoginSuccess(token: String, setListCount: Int) {
        // TODO Store the token
        // TODO if(setListCount == 1)  screen?.navigateToSets() else screen?.navigateToSetLists()
    }

    private fun onLoginFailed(message: String) {
        // TODO = screen?.showErrorMessage(message)
    }
}