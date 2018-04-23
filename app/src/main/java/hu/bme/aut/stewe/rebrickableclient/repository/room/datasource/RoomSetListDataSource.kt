package hu.bme.aut.stewe.rebrickableclient.repository.room.datasource

import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.SetList
import hu.bme.aut.stewe.rebrickableclient.repository.datasource.SetListDataSource
import hu.bme.aut.stewe.rebrickableclient.repository.room.RoomUnbrickableDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomSetListDataSource @Inject constructor(
        private var appDatabase: RoomUnbrickableDatabase
) : SetListDataSource {
    override fun getAll(): List<SetList> = appDatabase.setListDao().getAll()

    override fun insertAll(vararg items: SetList) = appDatabase.setListDao().insertAll(*items)

    override fun deleteAll() = appDatabase.setListDao().deleteAll()
}
