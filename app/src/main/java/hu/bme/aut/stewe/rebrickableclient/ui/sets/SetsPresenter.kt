package hu.bme.aut.stewe.rebrickableclient.ui.sets

import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.ui.Presenter


class SetsPresenter: Presenter<SetsScreen>() {
    init {
        injector.inject(this)
    }

    fun getSets(setListId:String){
        // TODO get data from service or DB
        // TODO screen?.showSets()
    }
}