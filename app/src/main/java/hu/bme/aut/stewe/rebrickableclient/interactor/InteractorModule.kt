package hu.bme.aut.stewe.rebrickableclient.interactor

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class InteractorModule {
    @Provides
    @Singleton
    fun provideLoginInteractor() = LoginInteractor()

    @Provides
    @Singleton
    fun provideSetDetailsInteractor() = SetDetailsInteractor()

    @Provides
    @Singleton
    fun provideSetListsInteractor() = SetListsInteractor()

    @Provides
    @Singleton
    fun provideSetsInteractor() = SetsInteractor()
}