package hu.bme.aut.stewe.rebrickableclient

import android.annotation.SuppressLint
import android.content.Context
import hu.bme.aut.stewe.rebrickableclient.ui.UIModule
import kotlin.reflect.KProperty


@SuppressLint("StaticFieldLeak")
object InjectorDelegate {
    var context: Context? = null
    private var component: AppComponent? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): AppComponent {
        if (component == null) {
            component = DaggerAppComponent
                    .builder()
                    .uiModule(UIModule(context!!))
                    .rebrickableServiceBaseUrl(getRebrickableServiceBaseUrl())
                    .rebrickableApiKey(getRebrickableApiKey())
                    .build()
        }
        return component!!
    }

    fun overrideInjector(value: AppComponent) {
        component = value
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: AppComponent) {
    }

    private fun getRebrickableServiceBaseUrl() = context?.getString(R.string.rebrickable_base_url)!!

    private fun getRebrickableApiKey() = context?.getString(R.string.rebrickable_key)!!

}