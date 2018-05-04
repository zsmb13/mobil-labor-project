package hu.bme.aut.stewe.rebrickableclient.ui

import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.view.ViewGroup
import hu.bme.aut.stewe.rebrickableclient.R


abstract class AppBarActivity : BaseActivity() {

    fun loadViewWithAppBar(@LayoutRes contentLayout: Int, @StringRes activityTitle: Int) {
        setContentView(R.layout.activity_appbar)

        val contentContainer = findViewById<ViewGroup>(R.id.contentContainer)

        contentContainer.inflate(contentLayout, true)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.apply {
            title = getString(activityTitle)
            setDisplayHomeAsUpEnabled(true)
        }
    }
}