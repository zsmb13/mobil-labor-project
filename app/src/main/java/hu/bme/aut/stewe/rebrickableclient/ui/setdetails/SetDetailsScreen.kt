package hu.bme.aut.stewe.rebrickableclient.ui.setdetails

import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.LegoSet
import hu.bme.aut.stewe.rebrickableclient.ui.BasicActionsScreen

interface SetDetailsScreen : BasicActionsScreen {
    fun showSetDetails(set: LegoSet)

    fun openSetDetailsPage(url: String)
}
