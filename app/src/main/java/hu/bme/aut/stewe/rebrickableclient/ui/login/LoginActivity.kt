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

    override fun showErrorMessage(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun navigateToSetLists() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
