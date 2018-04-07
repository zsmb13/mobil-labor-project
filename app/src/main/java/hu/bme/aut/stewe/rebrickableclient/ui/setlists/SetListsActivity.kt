package hu.bme.aut.stewe.rebrickableclient.ui.setlists

import android.os.Bundle
import android.os.PersistableBundle
import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.ui.BaseActivity
import javax.inject.Inject


class SetListsActivity : BaseActivity(), SetListsScreen {

    @Inject
    lateinit var presenter: SetListsPresenter

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        injector.inject(this)
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
        // TODO refresh setlists
    }

    override fun showErrorMessage(message: String) {
        TODO("not implemented")
    }

    override fun showSetLists(setLists: List<Any>) {
        TODO("not implemented")
    }

    override fun navigateToSets(setListId: String) {
        TODO("not implemented")
    }
}