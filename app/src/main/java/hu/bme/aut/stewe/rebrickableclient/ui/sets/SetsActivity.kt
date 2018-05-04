package hu.bme.aut.stewe.rebrickableclient.ui.sets

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearLayoutManager.VERTICAL
import android.support.v7.widget.RecyclerView
import hu.bme.aut.stewe.rebrickableclient.R
import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.LegoSet
import hu.bme.aut.stewe.rebrickableclient.ui.AppBarActivity
import hu.bme.aut.stewe.rebrickableclient.ui.longSnack
import hu.bme.aut.stewe.rebrickableclient.ui.setdetails.SetDetailsActivity
import hu.bme.aut.stewe.rebrickableclient.ui.sets.add.AddSetDialog
import kotlinx.android.synthetic.main.activity_sets.*
import javax.inject.Inject


class SetsActivity : AppBarActivity(), SetsScreen {
    @Inject
    lateinit var presenter: SetsPresenter

    private var setListId = -1L

    private var setListName = ""

    private lateinit var setsAdapter: SetsAdapter

    private lateinit var setsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)

        with(intent.extras) {
            setListId = getLong(EXTRA_SET_LIST_ID)
            setListName = getString(EXTRA_SET_LIST_NAME)
        }

        loadViewWithAppBar(R.layout.activity_sets,
                String.format(getString(R.string.sets_in_setlist_title_format), setListName))

        setsAdapter = SetsAdapter(this) { legoSet ->
            navigateToSetDetails(legoSet.setNum)
        }

        setsRecyclerView = findViewById(R.id.setsRecyclerView)

        setsRecyclerView.also {
            it.adapter = setsAdapter
            it.layoutManager = LinearLayoutManager(this, VERTICAL, false)
        }

        setAddButton.setOnClickListener {
            val dialog = AddSetDialog.newInstance()
            dialog.show(supportFragmentManager, "AddSetDialog")
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
        presenter.getSets(setListId)
    }

    override fun showErrorMessage(message: String) {
        hideLoading()
        setsRecyclerView.longSnack(message)
    }

    override fun showSets(sets: List<LegoSet>) {
        setsAdapter.refreshSets(sets)
        hideLoading()
    }

    override fun navigateToSetDetails(setId: String) {
        startActivity(SetDetailsActivity.getStartingIntent(this, setId))
    }

    override fun addSetToSetList(setId: String) {
        presenter.addSetToSetList(setId, setListId)
    }

    override fun onSetAdded() {
        showLoading()
        presenter.getSets(setListId)
    }

    companion object {
        const val EXTRA_SET_LIST_ID = "set_list_id"
        const val EXTRA_SET_LIST_NAME = "set_list_name"

        @JvmStatic
        fun getStartingIntent(from: Activity, setListId: Long, setListName: String): Intent {
            return Intent(from, SetsActivity::class.java).apply {
                putExtra(EXTRA_SET_LIST_ID, setListId)
                putExtra(EXTRA_SET_LIST_NAME, setListName)
            }
        }
    }
}
