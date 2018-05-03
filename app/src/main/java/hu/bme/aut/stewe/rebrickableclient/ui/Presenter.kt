package hu.bme.aut.stewe.rebrickableclient.ui

import hu.bme.aut.stewe.rebrickableclient.interactor.NetworkException
import hu.bme.aut.stewe.rebrickableclient.interactor.ServiceError
import hu.bme.aut.stewe.rebrickableclient.interactor.UserNotLoggedInException
import retrofit2.Response


abstract class Presenter<S : Screen> {
    var screen: S? = null

    open fun attachScreen(screen: S) {
        this.screen = screen
    }

    open fun detachScreen() {
        screen = null
    }

    // TODO Default lambda params will hopefully come in Kotlin 1.2!
    fun <T> handleResponse(
            response: Response<T>,
            onSuccess: (Response<T>) -> Unit,
            onServiceError: (ServiceError<T>) -> Unit,
            onNetworkException: (NetworkException<T>) -> Unit,
            onUserNotLoggedInException: (UserNotLoggedInException<T>) -> Unit
    ) {
        // TODO when Koltin 1.2 is released
    }
}