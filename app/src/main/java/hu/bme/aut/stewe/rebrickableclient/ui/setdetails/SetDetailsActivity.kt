package hu.bme.aut.stewe.rebrickableclient.ui.setdetails

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import hu.bme.aut.stewe.rebrickableclient.R
import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.LegoSet
import hu.bme.aut.stewe.rebrickableclient.ui.BaseActivity
import hu.bme.aut.stewe.rebrickableclient.ui.loadFromUrl
import hu.bme.aut.stewe.rebrickableclient.ui.longSnack
import kotlinx.android.synthetic.main.activity_set_details.*
import kotlinx.android.synthetic.main.activity_sets.*
import javax.inject.Inject


class SetDetailsActivity : BaseActivity(), SetDetailsScreen {
    @Inject
    lateinit var presenter: SetDetailsPresenter

    private lateinit var setNumber: String

    private lateinit var setUrl: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_details)
        injector.inject(this)

        setNumber = intent.extras.getString(EXTRA_SET_NUMBER)

        setDetailsShowDetailsWebPageButton.setOnClickListener {
            openSetDetailsPage(setUrl)
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
        showLoading()
        presenter.getSetDetails(setNumber)
    }

    override fun showSetDetails(set: LegoSet) {
        setDetailsImage.loadFromUrl(set.setImgUrl)
        setDetailsSetName.text = set.name
        setDetailsSetNumber.text = set.setNum
        setDetailsTheme.text = set.themeId.toString()
        setDetailsSubtheme.text = set.themeId.toString()
        setDetailsYear.text = set.year.toString()
        setDetailsParts.text = set.numParts.toString()

        setUrl = set.setUrl!!

        hideLoading()
    }

    override fun openSetDetailsPage(url: String) {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(url))
    }

    override fun showErrorMessage(message: String) {
        hideLoading()
        setsRecyclerView.longSnack(message)
    }

    companion object {
        const val EXTRA_SET_NUMBER = "set_number"

        @JvmStatic
        fun getStartingIntent(from: Activity, setNumber: String): Intent {
            return Intent(from, SetDetailsActivity::class.java).apply {
                putExtra(EXTRA_SET_NUMBER, setNumber)
            }
        }
    }
}
