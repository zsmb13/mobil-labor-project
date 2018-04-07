package hu.bme.aut.stewe.rebrickableclient.ui.sets

import android.os.Bundle
import android.os.PersistableBundle
import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.ui.BaseActivity
import javax.inject.Inject


class SetsActivity : BaseActivity(), SetsScreen {
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

    override fun onResume() {
        super.onResume()
        // TODO refresh sets
    }

    override fun showErrorMessage(message: String) {
        TODO("not implemented")
    }

    override fun showSets(sets: List<Any>) {
        TODO("not implemented")
    }

    override fun navigateToSetDetails(setId: String) {
        TODO("not implemented")
    }
}
