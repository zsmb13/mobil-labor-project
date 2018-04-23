package hu.bme.aut.stewe.rebrickableclient.repository.datasource

import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.SetList


interface SetListDataSource {
    fun getAll(): List<SetList>

    fun insertAll(vararg items: SetList)

    fun deleteAll()
}