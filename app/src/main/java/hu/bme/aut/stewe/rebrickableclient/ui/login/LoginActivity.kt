package hu.bme.aut.stewe.rebrickableclient.ui.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import hu.bme.aut.stewe.rebrickableclient.injector
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginScreen {
    @Inject
    lateinit var presenter : LoginPresenter

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

    override fun navigateToSets() {
        TODO("not implemented")
    }

    override fun navigateToSetLists() {
        TODO("not implemented")
    }

    override fun showErrorMessage(message: String) {
        TODO("not implemented")
    }
}
