package hu.bme.aut.stewe.rebrickableclient

import dagger.Component
import hu.bme.aut.stewe.rebrickableclient.network.NetworkModule
import hu.bme.aut.stewe.rebrickableclient.ui.UIModule
import hu.bme.aut.stewe.rebrickableclient.ui.login.LoginActivity
import hu.bme.aut.stewe.rebrickableclient.ui.setlists.SetListsActivity
import hu.bme.aut.stewe.rebrickableclient.ui.setlists.SetListsPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(loginActivity: LoginActivity)
    fun inject(setListsPresenter: SetListsPresenter)
    fun inject(setListsActivity: SetListsActivity)

}