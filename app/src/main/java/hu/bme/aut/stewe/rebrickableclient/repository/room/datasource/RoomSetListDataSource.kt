package hu.bme.aut.stewe.rebrickableclient.repository.room.datasource

import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.SetList
import hu.bme.aut.stewe.rebrickableclient.repository.DataSource
import hu.bme.aut.stewe.rebrickableclient.repository.room.RoomUnbrickableDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomSetListDataSource @Inject constructor(
        private var appDatabase: RoomUnbrickableDatabase
) : DataSource<SetList> {


    override fun addItem(item: SetList) {
        TODO("not implemented")
    }

    override fun addItems(items: List<SetList>) {
        TODO("not implemented")
    }

    override fun updateItem(item: SetList) {
        TODO("not implemented")
    }

    override fun updateItems(item: List<SetList>) {
        TODO("not implemented")
    }

    override fun removeItem(item: SetList) {
        TODO("not implemented")
    }

    override fun removeAll() {
        TODO("not implemented")
    }

}
