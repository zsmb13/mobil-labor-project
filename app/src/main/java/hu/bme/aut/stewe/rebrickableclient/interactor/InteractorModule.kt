package hu.bme.aut.stewe.rebrickableclient.interactor

import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import kotlinx.coroutines.experimental.android.UI as AndroidUI


@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideLoginInteractor() = LoginInteractor()
}