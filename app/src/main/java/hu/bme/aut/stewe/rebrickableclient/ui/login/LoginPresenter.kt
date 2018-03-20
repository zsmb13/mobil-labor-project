package hu.bme.aut.stewe.rebrickableclient.ui.login

import hu.bme.aut.stewe.rebrickableclient.network.swagger.api.UsersApi
import hu.bme.aut.stewe.rebrickableclient.ui.TaskPresenter
import javax.inject.Inject


class LoginPresenter(
        @Inject
        var usersApi: UsersApi
) : TaskPresenter<LoginScreen>() {

    fun tryLogin() {

    }

    private fun onLoginSuccess(token: String, setListCount:Int) {
        // TODO Store the token
        // TODO if(setListCount == 1)  screen?.navigateToSets() else screen?.navigateToSetLists()
    }

    private fun onLoginFailed(message: String){
        // TODO = screen?.showErrorMessage(message)
    }
}