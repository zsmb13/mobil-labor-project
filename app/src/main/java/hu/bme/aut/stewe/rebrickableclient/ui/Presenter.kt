package hu.bme.aut.stewe.rebrickableclient.ui


abstract class Presenter<S : Screen> {
    var screen: S? = null

    fun attachScreen(screen: S) {
        this.screen = screen
    }

    fun detachScreen() {
        screen = null
    }
}