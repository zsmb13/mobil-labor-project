package hu.bme.aut.stewe.rebrickableclient.ui

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UIModule(var context: Context) {
    @Provides
    @Singleton
    fun provideContext() = context
}