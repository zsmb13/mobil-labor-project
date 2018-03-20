package hu.bme.aut.stewe.rebrickableclient.ui.login

import hu.bme.aut.stewe.rebrickableclient.ui.BasicActionsScreen


interface LoginScreen : BasicActionsScreen {
    fun navigateToSetLists()

    fun navigateToSets()
}