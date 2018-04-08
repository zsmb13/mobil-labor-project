package hu.bme.aut.stewe.rebrickableclient.ui

import android.content.Context
import dagger.Module
import dagger.Provides
import hu.bme.aut.stewe.rebrickableclient.interactor.LoginInteractor
import hu.bme.aut.stewe.rebrickableclient.interactor.SetDetailsInteractor
import hu.bme.aut.stewe.rebrickableclient.interactor.SetListsInteractor
import hu.bme.aut.stewe.rebrickableclient.interactor.SetsInteractor
import hu.bme.aut.stewe.rebrickableclient.ui.login.LoginPresenter
import hu.bme.aut.stewe.rebrickableclient.ui.setdetails.SetDetailsPresenter
import hu.bme.aut.stewe.rebrickableclient.ui.setlists.SetListsPresenter
import hu.bme.aut.stewe.rebrickableclient.ui.sets.SetsPresenter
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
    fun provideLoginInteractor() = LoginInteractor()

    @Provides
    @Singleton
    fun provideSetDetailsPresenter() = SetDetailsPresenter()

    @Provides
    @Singleton
    fun provideSetDetailsInteractor() = SetDetailsInteractor()

    @Provides
    @Singleton
    fun provideSetListsPresenter() = SetListsPresenter()

    @Provides
    @Singleton
    fun provideSetListssInteractor() = SetListsInteractor()

    @Provides
    @Singleton
    fun provideSetsPresenter() = SetsPresenter()

    @Provides
    @Singleton
    fun provideSetsDetailsInteractor() = SetsInteractor()


}