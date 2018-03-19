package hu.bme.aut.stewe.rebrickableclient.ui


interface Screen

interface BasicActionsScreen : Screen {
    fun showErrorMessage(message: String)
}