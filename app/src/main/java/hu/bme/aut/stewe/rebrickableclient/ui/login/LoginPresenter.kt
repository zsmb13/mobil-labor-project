package hu.bme.aut.stewe.rebrickableclient.ui.login

import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.interactor.LoginInteractor
import hu.bme.aut.stewe.rebrickableclient.network.NetworkException
import hu.bme.aut.stewe.rebrickableclient.network.ServiceError
import hu.bme.aut.stewe.rebrickableclient.network.Success
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.UserToken
import hu.bme.aut.stewe.rebrickableclient.ui.Presenter
import kotlinx.coroutines.experimental.runBlocking
import javax.inject.Inject


class LoginPresenter : Presenter<LoginScreen>() {

    @Inject
    lateinit var loginInteractor: LoginInteractor

    init {
        injector.inject(this)
    }

    fun login(username: String, password: String) = runBlocking {
        val result = loginInteractor.getUserToken(username, password)

        when (result) {
            is Success -> onLoginSuccess(result)
            is ServiceError -> screen?.showErrorMessage(result.error.message())
            is NetworkException -> screen?.showErrorMessage(result.exception.message!!)
        }
    }

    private suspend fun onLoginSuccess(userTokenResult: Success<UserToken>) {
        loginInteractor.storeToken(userTokenResult.value.userToken!!)
        val setListResult = loginInteractor.getUserSetListCount()

        when (setListResult) {
            is Success -> screen?.navigateToSetLists()
            is ServiceError -> screen?.showErrorMessage(setListResult.error.message())
            is NetworkException -> screen?.showErrorMessage(setListResult.exception.message!!)
        }
    }
}