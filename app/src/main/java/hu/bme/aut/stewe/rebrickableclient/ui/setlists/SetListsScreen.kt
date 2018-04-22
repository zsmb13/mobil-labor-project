package hu.bme.aut.stewe.rebrickableclient.ui.setlists

import hu.bme.aut.stewe.rebrickableclient.ui.BasicActionsScreen


interface SetListsScreen : BasicActionsScreen {
    fun showSetLists(setLists: List<Any>)

    fun navigateToSets(setListId: Long)
}