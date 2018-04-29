package hu.bme.aut.stewe.rebrickableclient.ui

import android.content.Context
import dagger.Module
import dagger.Provides
import hu.bme.aut.stewe.rebrickableclient.ui.login.LoginPresenter
import hu.bme.aut.stewe.rebrickableclient.ui.setdetails.SetDetailsPresenter
import hu.bme.aut.stewe.rebrickableclient.ui.setlists.SetListsPresenter
import hu.bme.aut.stewe.rebrickableclient.ui.sets.SetsPresenter
import javax.inject.Singleton

@Module
open class UIModule(var context: Context) {
    @Provides
    @Singleton
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideLoginPresenter() = LoginPresenter()

    @Provides
    @Singleton
    fun provideSetDetailsPresenter() = SetDetailsPresenter()

    @Provides
    @Singleton
    fun provideSetListsPresenter() = SetListsPresenter()

    @Provides
    @Singleton
    fun provideSetsPresenter() = SetsPresenter()
}