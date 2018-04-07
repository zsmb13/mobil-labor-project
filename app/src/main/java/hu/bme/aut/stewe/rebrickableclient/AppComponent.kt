package hu.bme.aut.stewe.rebrickableclient

import dagger.BindsInstance
import dagger.Component
import hu.bme.aut.stewe.rebrickableclient.interactor.InteractorModule
import hu.bme.aut.stewe.rebrickableclient.interactor.LoginInteractor
import hu.bme.aut.stewe.rebrickableclient.network.NetworkModule
import hu.bme.aut.stewe.rebrickableclient.ui.UIModule
import hu.bme.aut.stewe.rebrickableclient.ui.login.LoginActivity
import hu.bme.aut.stewe.rebrickableclient.ui.login.LoginPresenter
import hu.bme.aut.stewe.rebrickableclient.ui.setdetails.SetDetailsActivity
import hu.bme.aut.stewe.rebrickableclient.ui.setlists.SetListsActivity
import hu.bme.aut.stewe.rebrickableclient.ui.setlists.SetListsPresenter
import hu.bme.aut.stewe.rebrickableclient.ui.sets.SetsActivity
import hu.bme.aut.stewe.rebrickableclient.ui.sets.SetsPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, NetworkModule::class, InteractorModule::class])
interface AppComponent {
    fun inject(loginActivity: LoginActivity)
    fun inject(setListsPresenter: SetListsPresenter)
    fun inject(setListsActivity: SetListsActivity)
    fun inject(setsPresenter: SetsPresenter)
    fun inject(setsActivity: SetsActivity)
    fun inject(setDetailsActivity: SetDetailsActivity)
    fun inject(loginInteractor: LoginInteractor)
    fun inject(loginPresenter: LoginPresenter)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        fun uiModule(uiModule: UIModule) : Builder

        @BindsInstance
        fun rebrickableBaseUrl(@NetworkModule.RebrickableBaseUrl url:String) : Builder
    }
}