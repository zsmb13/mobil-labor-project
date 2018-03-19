package hu.bme.aut.stewe.rebrickableclient

import android.app.Application
import hu.bme.aut.stewe.rebrickableclient.ui.UIModule


class UnbrickableApplication : Application() {

    companion object {
        val injector: AppComponent by lazy {
            DaggerAppComponent
                    .builder()
                    .application(this)
                    .build()
        }
    }
}