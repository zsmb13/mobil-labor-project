package hu.bme.aut.stewe.rebrickableclient

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import hu.bme.aut.stewe.rebrickableclient.ui.UIModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(UIModule::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }

}