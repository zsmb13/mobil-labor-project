package hu.bme.aut.stewe.rebrickableclient.ui

import android.support.annotation.LayoutRes
import android.view.MenuItem
import android.view.ViewGroup
import hu.bme.aut.stewe.rebrickableclient.R


abstract class AppBarActivity : BaseActivity() {

    fun loadViewWithAppBar(@LayoutRes contentLayout: Int, activityTitle: String) {
        setContentView(R.layout.activity_appbar)

        val contentContainer = findViewById<ViewGroup>(R.id.contentContainer)

        contentContainer.inflate(contentLayout, true)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.apply {
            title = activityTitle
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}