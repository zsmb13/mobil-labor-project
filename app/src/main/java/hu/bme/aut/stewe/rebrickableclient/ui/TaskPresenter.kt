package hu.bme.aut.stewe.rebrickableclient.ui

import hu.axolotl.tasklib.android.TaskEngineHolder

abstract class TaskPresenter<S : Screen> : Presenter<S>(){
    private val holder = TaskEngineHolder(this)

    override fun attachScreen(screen: S) {
        super.attachScreen(screen)
        holder.start()
    }

    override fun detachScreen() {
        super.detachScreen()
        holder.stop()
    }
}