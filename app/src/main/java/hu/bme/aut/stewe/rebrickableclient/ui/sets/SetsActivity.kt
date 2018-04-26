package hu.bme.aut.stewe.rebrickableclient.ui.sets

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearLayoutManager.VERTICAL
import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.LegoSet
import hu.bme.aut.stewe.rebrickableclient.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_sets.*
import javax.inject.Inject


class SetsActivity : BaseActivity(), SetsScreen {
    @Inject
    lateinit var presenter: SetsPresenter

    private var seListId = -1L

    private lateinit var setsAdapter: SetsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        seListId = intent.extras.getLong(EXTRA_SET_LIST_ID)

        setsAdapter = SetsAdapter(this) { legoSet ->
            navigateToSetDetails(legoSet.setNum)
        }

        setsRecyclerView.also {
            it.adapter = setsAdapter
            it.layoutManager = LinearLayoutManager(this, VERTICAL, false)
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
        presenter.getSets(seListId)
    }

    override fun showErrorMessage(message: String) {
        TODO("not implemented")
    }

    override fun showSets(sets: List<LegoSet>) {
        TODO("not implemented")
    }

    override fun navigateToSetDetails(setId: String) {

    }

    companion object {
        const val EXTRA_SET_LIST_ID = "set_list_id"

        @JvmStatic
        fun getStartingIntent(from: Activity, setListId: Long): Intent {
            return Intent(from, SetsActivity::class.java).apply {
                putExtra(EXTRA_SET_LIST_ID, setListId)
            }
        }
    }
}
