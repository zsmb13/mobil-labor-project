package hu.bme.aut.stewe.rebrickableclient.ui.setdetails

import hu.bme.aut.stewe.rebrickableclient.ui.BasicActionsScreen

interface SetDetailsScreen : BasicActionsScreen {
    fun showSetDetails(set: Any)

    fun openSetDetailsPage(url: String)
}
