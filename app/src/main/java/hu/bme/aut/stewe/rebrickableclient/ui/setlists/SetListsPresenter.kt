package hu.bme.aut.stewe.rebrickableclient.ui.setlists

import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.ui.Presenter


class SetListsPresenter : Presenter<SetListsScreen>() {

    init {
        injector.inject(this)
    }

    fun getSetLists(){
        // TODO retrieve set lists from server or repository
        // TODO if set list count is 1
        //      screen?.navigateToSets(setListId: String)
        // else
        //      screen?.showSetLists(result)
    }
}