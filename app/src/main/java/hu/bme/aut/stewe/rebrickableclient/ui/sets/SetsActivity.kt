package hu.bme.aut.stewe.rebrickableclient.ui.sets

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import hu.bme.aut.stewe.rebrickableclient.injector
import javax.inject.Inject


class SetsActivity : AppCompatActivity(), SetsScreen {
    @Inject
    lateinit var presenter: SetsPresenter

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        injector.inject(this)
    }

    override fun onStart() {
        super.onStart()
        presenter.attachScreen(this)
    }

    override fun onStop() {
        presenter.detachScreen()
        super.onStop()
    }

    override fun showErrorMessage(message: String) {
        TODO("not implemented")
    }

    override fun showSets(sets: List<Any>) {
        TODO("not implemented")
    }
}
