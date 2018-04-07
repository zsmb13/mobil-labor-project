package hu.bme.aut.stewe.rebrickableclient.ui.sets

import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.interactor.SetsInteractor
import hu.bme.aut.stewe.rebrickableclient.ui.Presenter
import javax.inject.Inject


class SetsPresenter: Presenter<SetsScreen>() {

    @Inject
    lateinit var setsInteractor: SetsInteractor

    init {
        injector.inject(this)
    }

    fun getSets(setListId:String){
        // TODO get data from service or DB
        // TODO screen?.showSets()
    }
}