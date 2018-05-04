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

        val isLogoutRequested = intent.getBooleanExtra(EXTRA_LOGOUT_REQUESTED, false)

        if (isLogoutRequested) presenter.logout()

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
        startActivity(SetListsActivity.getStartingIntent(this))
        finish()
    }

    override fun showErrorMessage(message: String) {
        loginButton.longSnack(message)
        Log.d(this.javaClass.simpleName, message)
    }

    companion object {
        private const val EXTRA_LOGOUT_REQUESTED = "extra_logout_requested"

        fun getStartingIntent(from: Activity, logoutRequested: Boolean = false): Intent {
            val intent = Intent(from, LoginActivity::class.java)
            return intent.apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                putExtra(EXTRA_LOGOUT_REQUESTED, logoutRequested)
            }
        }
    }
}
