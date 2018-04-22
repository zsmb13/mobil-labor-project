package hu.bme.aut.stewe.rebrickableclient.repository

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import hu.bme.aut.stewe.rebrickableclient.repository.datasource.LegoSetDataSource
import hu.bme.aut.stewe.rebrickableclient.repository.datasource.SetListDataSource
import hu.bme.aut.stewe.rebrickableclient.repository.datasource.UserTokenDataSource
import hu.bme.aut.stewe.rebrickableclient.repository.room.RoomUnbrickableDatabase
import hu.bme.aut.stewe.rebrickableclient.repository.room.datasource.RoomLegoSetDataSource
import hu.bme.aut.stewe.rebrickableclient.repository.room.datasource.RoomSetListDataSource
import hu.bme.aut.stewe.rebrickableclient.repository.room.datasource.RoomUserTokenDataSource
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(context: Context) = Room.databaseBuilder(context, RoomUnbrickableDatabase::class.java, "default-database").build()

    @Provides
    @Singleton
    fun provideRepository(userTokenData: UserTokenDataSource,
                          setListData: SetListDataSource,
                          legoSetsData: LegoSetDataSource): Repository = DefaultRepository(userTokenData, setListData, legoSetsData)

    @Provides
    @Singleton
    fun provideUserTokenDataSource(appDatabase: RoomUnbrickableDatabase): UserTokenDataSource = RoomUserTokenDataSource(appDatabase)

    @Provides
    @Singleton
    fun provideSetListDataSource(appDatabase: RoomUnbrickableDatabase): SetListDataSource = RoomSetListDataSource(appDatabase)

    @Provides
    @Singleton
    fun provideLegoSetDataSource(appDatabase: RoomUnbrickableDatabase): LegoSetDataSource = RoomLegoSetDataSource(appDatabase)

}