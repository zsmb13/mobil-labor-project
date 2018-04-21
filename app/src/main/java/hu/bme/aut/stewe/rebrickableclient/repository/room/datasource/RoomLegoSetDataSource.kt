package hu.bme.aut.stewe.rebrickableclient.repository.room.datasource

import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.LegoSet
import hu.bme.aut.stewe.rebrickableclient.repository.DataSource
import hu.bme.aut.stewe.rebrickableclient.repository.room.RoomUnbrickableDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomLegoSetDataSource@Inject constructor(
        private var appDatabase: RoomUnbrickableDatabase
) : DataSource<LegoSet> {
    override fun addItem(item: LegoSet) {
        TODO("not implemented")
    }

    override fun addItems(items: List<LegoSet>) {
        TODO("not implemented")
    }

    override fun updateItem(item: LegoSet) {
        TODO("not implemented")
    }

    override fun updateItems(item: List<LegoSet>) {
        TODO("not implemented")
    }

    override fun removeItem(item: LegoSet) {
        TODO("not implemented")
    }

    override fun removeAll() {
        TODO("not implemented")
    }

}
