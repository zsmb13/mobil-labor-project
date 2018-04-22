package hu.bme.aut.stewe.rebrickableclient.ui.setdetails

import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.interactor.*
import hu.bme.aut.stewe.rebrickableclient.launchAsync
import hu.bme.aut.stewe.rebrickableclient.ui.Presenter
import javax.inject.Inject

class SetDetailsPresenter : Presenter<SetDetailsScreen>() {

    @Inject
    lateinit var setDetailsInteractor : SetDetailsInteractor

    init {
        injector.inject(this)
    }

    fun getSetDetails(setId: String) = launchAsync {
        var result = setDetailsInteractor.getLegoSetDetails(setId)
        when (result) {
            is Success -> screen?.showSetDetails(result.value)
            is ServiceError -> screen?.showErrorMessage(result.error.message!!)
            is NetworkException -> screen?.showErrorMessage(result.exception.message!!)
            is UserNotLoggedInException -> screen?.showErrorMessage("TODO user should not be here!")
        }
    }
}