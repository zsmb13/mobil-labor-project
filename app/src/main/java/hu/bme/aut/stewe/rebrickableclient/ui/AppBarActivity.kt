package hu.bme.aut.stewe.rebrickableclient.ui

import android.support.annotation.LayoutRes
import android.view.Menu
import android.view.MenuItem
import hu.bme.aut.stewe.rebrickableclient.R
import hu.bme.aut.stewe.rebrickableclient.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_appbar.*


abstract class AppBarActivity : BaseActivity() {

    fun loadViewWithAppBar(@LayoutRes contentLayout: Int, activityTitle: String) {
        setContentView(R.layout.activity_appbar)

        contentContainer.inflate(contentLayout, true)

        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = activityTitle
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.simple_menu_logout, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean =
            when (item?.itemId) {
                android.R.id.home -> {
                    onBackPressed()
                    true
                }
                R.id.menu_item_logout -> {
                    startActivity(LoginActivity.getStartingIntent(this, true))
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }
}