package hu.bme.aut.stewe.rebrickableclient.ui.setdetails

import android.os.Bundle
import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.ui.BaseActivity
import javax.inject.Inject

class SetDetailsActivity : BaseActivity(), SetDetailsScreen {
    @Inject
    lateinit var presenter: SetDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        presenter.getSetDetails("")
    }

    override fun showSetDetails(set: Any) {
        TODO("not implemented")
    }

    override fun showErrorMessage(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
