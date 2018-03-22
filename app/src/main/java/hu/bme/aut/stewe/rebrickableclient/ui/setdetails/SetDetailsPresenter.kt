package hu.bme.aut.stewe.rebrickableclient.ui.setdetails

import hu.bme.aut.stewe.rebrickableclient.ui.Presenter

class SetDetailsPresenter : Presenter<SetDetailsScreen>() {
    fun getSetDetails(setId: String) {
        // TODO get set details from service
        // if(success) onFetchSuccessful(result)
        // else onFetchFailed(error_cause)
    }

    private fun onFetchSetSuccessful(set: Any) = screen?.showSetDetails(set)

    private fun onFetchFailed(message: String) = screen?.showErrorMessage(message)
}