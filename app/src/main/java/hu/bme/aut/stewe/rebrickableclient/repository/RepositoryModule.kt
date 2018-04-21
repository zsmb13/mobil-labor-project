package hu.bme.aut.stewe.rebrickableclient.repository

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import hu.bme.aut.stewe.rebrickableclient.repository.datasource.LegoSetDataSource
import hu.bme.aut.stewe.rebrickableclient.repository.datasource.SetListDataSource
import hu.bme.aut.stewe.rebrickableclient.repository.datasource.UserTokenDataSource
import hu.bme.aut.stewe.rebrickableclient.repository.room.RoomUnbrickableDatabase
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(context:Context) = Room.databaseBuilder(context, RoomUnbrickableDatabase::class.java, "default-database").build()

    @Provides
    @Singleton
    fun provideRepository(userTokenData: UserTokenDataSource,
                          setListData: SetListDataSource,
                          legoSetsData: LegoSetDataSource): Repository = DefaultRepository(userTokenData, setListData, legoSetsData)
}