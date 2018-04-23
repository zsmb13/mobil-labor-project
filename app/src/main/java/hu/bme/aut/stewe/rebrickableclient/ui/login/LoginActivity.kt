package hu.bme.aut.stewe.rebrickableclient.ui.login

import android.os.Bundle
import hu.bme.aut.stewe.rebrickableclient.R
import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.ui.BaseActivity
import hu.bme.aut.stewe.rebrickableclient.ui.longSnack
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginScreen {
    @Inject
    lateinit var presenter : LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        injector.inject(this)

        loginButton.setOnClickListener {
            presenter.login(loginUserName.text.toString(), loginPassword.text.toString())
        }
    }

    override fun onStart() {
        super.onStart()
        presenter.attachScreen(this)
    }

    override fun onStop() {
        presenter.detachScreen()
        super.onStop()
    }

    override fun navigateToSetLists() {
        TODO("not implemented")
    }

    override fun showErrorMessage(message: String) {
        loginButton.longSnack(message)
    }
}
