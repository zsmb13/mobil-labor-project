package hu.bme.aut.stewe.rebrickableclient

import dagger.Component
import hu.bme.aut.stewe.rebrickableclient.ui.UIModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(UIModule::class)])
interface AppComponent {

}