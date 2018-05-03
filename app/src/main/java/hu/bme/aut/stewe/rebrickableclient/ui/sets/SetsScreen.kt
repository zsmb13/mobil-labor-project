package hu.bme.aut.stewe.rebrickableclient.ui.sets

import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.LegoSet
import hu.bme.aut.stewe.rebrickableclient.ui.BasicActionsScreen


interface SetsScreen : BasicActionsScreen {
    fun showSets(sets: List<LegoSet>)

    fun navigateToSetDetails(setId: String)

    fun addSetToSetList(setId: String)

    fun onSetAdded()
}