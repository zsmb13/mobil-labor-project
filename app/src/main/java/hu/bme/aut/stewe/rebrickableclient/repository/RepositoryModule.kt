package hu.bme.aut.stewe.rebrickableclient.repository

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.SetList
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.SetListLegoSet
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.UserToken
import hu.bme.aut.stewe.rebrickableclient.repository.room.RoomUnbrickableDatabase
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(context:Context) = Room.databaseBuilder(context, RoomUnbrickableDatabase::class.java, "default-database").build()

    @Provides
    @Singleton
    fun provideRepository(userTokenData: DataSource<UserToken>,
                          setListData: DataSource<SetList>,
                          setsData: DataSource<SetListLegoSet>) : Repository = DefaultRepository(userTokenData, setListData, setsData)
}