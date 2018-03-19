package hu.bme.aut.stewe.rebrickableclient.ui


abstract class Presenter<S : Screen> {
    var screen: S? = null

    open fun attachScreen(screen: S) {
        this.screen = screen
    }

    open fun detachScreen() {
        screen = null
    }
}