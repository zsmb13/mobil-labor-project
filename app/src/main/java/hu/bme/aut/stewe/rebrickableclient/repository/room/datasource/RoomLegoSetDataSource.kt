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
    override fun getAll(): List<LegoSet> = appDatabase.legoSetDao().getAll()

    override fun insertAll(vararg legoSets: LegoSet) = appDatabase.legoSetDao().insertAll(*legoSets)

    override fun deleteAll() = appDatabase.legoSetDao().deleteAll()
}
