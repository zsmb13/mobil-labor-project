package hu.bme.aut.stewe.rebrickableclient.ui.sets

import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.interactor.*
import hu.bme.aut.stewe.rebrickableclient.launchAsync
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.LegoSetsInSetList
import hu.bme.aut.stewe.rebrickableclient.ui.Presenter
import javax.inject.Inject


class SetsPresenter : Presenter<SetsScreen>() {

    @Inject
    lateinit var setsInteractor: SetsInteractor

    init {
        injector.inject(this)
    }

    fun getSets(setListId: Long) = launchAsync {
        val result = setsInteractor.getLegoSets(setListId)
        when (result) {
            is Success -> onSetsAvailable(result)
            is ServiceError -> screen?.showErrorMessage(result.error.message!!)
            is NetworkException -> screen?.showErrorMessage(result.exception.message!!)
            is UserNotLoggedInException -> screen?.showErrorMessage("TODO user should not be here!")
        }
    }

    fun addSetToSetList(setId: String, setListId: Long) = launchAsync {
        val result = setsInteractor.addSetToSetList(setId, setListId)
        when (result) {
            is Success -> onSetAdded(result)
            is ServiceError -> screen?.showErrorMessage(result.error.message!!)
            is NetworkException -> screen?.showErrorMessage(result.exception.message!!)
            is UserNotLoggedInException -> screen?.showErrorMessage("TODO user should not be here!")
        }
    }

    private fun onSetsAvailable(result: Success<LegoSetsInSetList>) {
        val sets = result.value.results.map { it -> it.set!! }
        screen?.showSets(sets)
    }

    private fun onSetAdded(result: Success<Void>) {
        screen?.onSetAdded()
    }
}