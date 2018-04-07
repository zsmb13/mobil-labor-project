package hu.bme.aut.stewe.rebrickableclient.ui.sets

import hu.bme.aut.stewe.rebrickableclient.ui.BasicActionsScreen


interface SetsScreen : BasicActionsScreen {
    fun showSets(sets: List<Any>)

    fun navigateToSetDetails(setId: String)
}