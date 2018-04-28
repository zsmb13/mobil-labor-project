package hu.bme.aut.stewe.rebrickableclient.ui.setlists

import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.SetList
import hu.bme.aut.stewe.rebrickableclient.ui.BasicActionsScreen


interface SetListsScreen : BasicActionsScreen {
    fun showSetLists(setLists: List<SetList>)

    fun navigateToSets(setListId: Long)
}