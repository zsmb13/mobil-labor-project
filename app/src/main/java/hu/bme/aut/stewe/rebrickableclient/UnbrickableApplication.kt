package hu.bme.aut.stewe.rebrickableclient

import android.app.Application

class UnbrickableApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        InjectorDelegate.context = this
    }
    

}

val injector: AppComponent by InjectorDelegate