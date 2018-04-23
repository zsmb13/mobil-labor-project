package hu.bme.aut.stewe.rebrickableclient.ui.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import hu.bme.aut.stewe.rebrickableclient.R
import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.ui.BaseActivity
import hu.bme.aut.stewe.rebrickableclient.ui.longSnack
import hu.bme.aut.stewe.rebrickableclient.ui.setlists.SetListsActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginScreen {
    @Inject
    lateinit var presenter: LoginPresenter

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

    override fun onResume() {
        super.onResume()
        presenter.checkIfLoggedIn()
    }

    override fun navigateToSetLists() {
        startActivity(SetListsActivity.Companion.getStartingIntent(this))
        finish()
    }

    override fun showErrorMessage(message: String) {
        loginButton.longSnack(message)
        Log.d(this.javaClass.simpleName, message)
    }

    companion object {
        @JvmStatic
        fun getStartingIntent(from: Activity): Intent {
            return Intent(from, LoginActivity::class.java)
        }
    }
}
