package hu.bme.aut.stewe.rebrickableclient.ui

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Toast


abstract class BaseActivity : AppCompatActivity() {

    private var progressDialog: ProgressDialog? = null

    protected fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    protected fun showLoading() {
        progressDialog = ProgressDialog.show(this, null, "Loading...")
    }

    protected fun hideLoading() {
        progressDialog?.dismiss()
    }
}

