package hu.bme.aut.stewe.rebrickableclient.ui.setlists

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearLayoutManager.VERTICAL
import hu.bme.aut.stewe.rebrickableclient.R
import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.SetList
import hu.bme.aut.stewe.rebrickableclient.ui.BaseActivity
import hu.bme.aut.stewe.rebrickableclient.ui.longSnack
import hu.bme.aut.stewe.rebrickableclient.ui.sets.SetsActivity
import kotlinx.android.synthetic.main.activity_setlists.*
import javax.inject.Inject


class SetListsActivity : BaseActivity(), SetListsScreen {

    @Inject
    lateinit var presenter: SetListsPresenter

    private lateinit var adapter: SetListsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setlists)
        injector.inject(this)

        adapter = SetListsAdapter(this) { setList ->
            navigateToSets(setList.id!!)
        }

        setListsRecyclerView.adapter = adapter
        setListsRecyclerView.layoutManager = LinearLayoutManager(this, VERTICAL, false)
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
        presenter.getSetLists()
    }

    override fun showErrorMessage(message: String) {
        setListsRecyclerView.longSnack(message)
    }

    override fun showSetLists(setLists: List<SetList>) = adapter.refreshSetLists(setLists)

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