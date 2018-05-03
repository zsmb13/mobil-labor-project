package hu.bme.aut.stewe.rebrickableclient.ui.setlists

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearLayoutManager.VERTICAL
import android.support.v7.widget.RecyclerView
import hu.bme.aut.stewe.rebrickableclient.R
import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.SetList
import hu.bme.aut.stewe.rebrickableclient.ui.AppBarActivity
import hu.bme.aut.stewe.rebrickableclient.ui.longSnack
import hu.bme.aut.stewe.rebrickableclient.ui.sets.SetsActivity
import javax.inject.Inject


class SetListsActivity : AppBarActivity(), SetListsScreen {

    @Inject
    lateinit var presenter: SetListsPresenter

    private lateinit var setListAdapter: SetListsAdapter

    private lateinit var setListsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadViewWithAppBar(R.layout.activity_setlists, R.string.setlists)
        injector.inject(this)

        setListAdapter = SetListsAdapter(this) { setList ->
            navigateToSets(setList.id!!)
        }

        setListsRecyclerView = findViewById(R.id.setListsRecyclerView)

        setListsRecyclerView.also {
            it.adapter = setListAdapter
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
        showLoading()
        presenter.getSetLists()
    }

    override fun showErrorMessage(message: String) {
        hideLoading()
        setListsRecyclerView.longSnack(message)
    }

    override fun showSetLists(setLists: List<SetList>) {
        hideLoading()
        setListAdapter.refreshSetLists(setLists)
    }

    override fun navigateToSets(setListId: Long) {
        startActivity(SetsActivity.getStartingIntent(this, setListId))
    }

    companion object {
        @JvmStatic
        fun getStartingIntent(from: Activity): Intent {
            return Intent(from, SetListsActivity::class.java)
        }
    }
}