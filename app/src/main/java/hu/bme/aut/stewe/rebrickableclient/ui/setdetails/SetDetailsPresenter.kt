package hu.bme.aut.stewe.rebrickableclient.ui.setdetails

import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.interactor.SetDetailsInteractor
import hu.bme.aut.stewe.rebrickableclient.ui.Presenter
import javax.inject.Inject

class SetDetailsPresenter : Presenter<SetDetailsScreen>() {

    @Inject
    lateinit var setDetailsInteractor : SetDetailsInteractor

    init {
        injector.inject(this)
    }

    fun getSetDetails(setId: String) {
        // TODO get set details from service
        // if(success) onFetchSuccessful(result)
        // else onFetchFailed(error_cause)
    }

    private fun onFetchSetSuccessful(set: Any) = screen?.showSetDetails(set)

    private fun onFetchFailed(message: String) = screen?.showErrorMessage(message)
}