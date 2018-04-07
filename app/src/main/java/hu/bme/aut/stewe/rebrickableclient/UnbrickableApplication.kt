package hu.bme.aut.stewe.rebrickableclient

import android.app.Application
import hu.axolotl.tasklib.annotation.Injector

class UnbrickableApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        InjectorDelegate.context = this
    }
    

}

@Injector
var Any?.injector: AppComponent by InjectorDelegate