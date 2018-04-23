package hu.bme.aut.stewe.rebrickableclient.ui.setlists

import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.interactor.*
import hu.bme.aut.stewe.rebrickableclient.launchAsync
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.SetList
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.SetLists
import hu.bme.aut.stewe.rebrickableclient.ui.Presenter
import javax.inject.Inject


class SetListsPresenter : Presenter<SetListsScreen>() {

    @Inject
    lateinit var setListsInteractor: SetListsInteractor

    init {
        injector.inject(this)
    }

    fun getSetLists() = launchAsync {

        var result = setListsInteractor.getUserSetLists()

        when (result) {
            is Success -> onSetListsAvailable(result.value)
            is ServiceError -> screen?.showErrorMessage(result.error.message())
            is NetworkException -> screen?.showErrorMessage(result.exception.message!!)
            is UserNotLoggedInException -> screen?.showErrorMessage("TODO user should not be here!")
        }
    }

    private fun onSetListsAvailable(setLists: SetLists) {
        if (setLists.count?.equals(1)!!) {
            screen?.navigateToSets(setLists.results[0].id!!)
        } else {
            screen?.showSetLists(setLists.results)
        }
    }

    private fun onFetchSetSuccessful(setLists: List<SetList>) = screen?.showSetLists(setLists)

    private fun onFetchFailed(message: String) = screen?.showErrorMessage(message)
}