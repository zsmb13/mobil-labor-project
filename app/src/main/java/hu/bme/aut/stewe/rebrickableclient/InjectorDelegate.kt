package hu.bme.aut.stewe.rebrickableclient

import android.annotation.SuppressLint
import android.content.Context
import hu.bme.aut.stewe.rebrickableclient.ui.UIModule
import kotlin.reflect.KProperty


@SuppressLint("StaticFieldLeak")
object InjectorDelegate {

    lateinit var context: Context

    private lateinit var component: AppComponent

    operator fun getValue(thisRef: Any?, property: KProperty<*>): AppComponent {
        if (::component.isInitialized.not()) {
            component = DaggerAppComponent
                    .builder()
                    .uiModule(UIModule(context))
                    .rebrickableServiceBaseUrl(getRebrickableServiceBaseUrl())
                    .rebrickableApiKey(getRebrickableApiKey())
                    .build()
        }
        return component
    }

    fun overrideInjector(value: AppComponent) {
        component = value
    }

    private fun getRebrickableServiceBaseUrl() = context.getString(R.string.rebrickable_base_url)!!

    private fun getRebrickableApiKey() = context.getString(R.string.rebrickable_key)!!

}