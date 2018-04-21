package hu.bme.aut.stewe.rebrickableclient.repository.room.datasource

import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.LegoSet
import hu.bme.aut.stewe.rebrickableclient.repository.datasource.LegoSetDataSource
import hu.bme.aut.stewe.rebrickableclient.repository.room.RoomUnbrickableDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomLegoSetDataSource @Inject constructor(
        private var appDatabase: RoomUnbrickableDatabase
) : LegoSetDataSource {
    override suspend fun getAll(): List<LegoSet> = appDatabase.legoSetDao().getAll()

    override suspend fun insertAll(vararg legoSets: LegoSet) = appDatabase.legoSetDao().insertAll(*legoSets)

    override suspend fun deleteAll() = appDatabase.legoSetDao().deleteAll()
}
