package hu.bme.aut.stewe.rebrickableclient.ui

import android.content.Context
import dagger.Module
import dagger.Provides
import hu.bme.aut.stewe.rebrickableclient.ui.login.LoginPresenter
import hu.bme.aut.stewe.rebrickableclient.ui.setdetails.SetDetailsPresenter
import javax.inject.Singleton

@Module
class UIModule(var context: Context) {
    @Provides
    @Singleton
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideLoginPresenter() = LoginPresenter()

    @Provides
    @Singleton
    fun provideSetDetailsPresenter() = SetDetailsPresenter()
}