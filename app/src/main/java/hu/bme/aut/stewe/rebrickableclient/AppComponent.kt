package hu.bme.aut.stewe.rebrickableclient

import dagger.Component
import hu.bme.aut.stewe.rebrickableclient.network.NetworkModule
import hu.bme.aut.stewe.rebrickableclient.ui.UIModule
import hu.bme.aut.stewe.rebrickableclient.ui.login.LoginActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(loginActivity: LoginActivity)

}