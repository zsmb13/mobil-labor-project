package hu.bme.aut.stewe.rebrickableclient.repository.datasource

import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.SetList


interface SetListDataSource {
    suspend fun getAll(): List<SetList>

    suspend fun insertAll(vararg items: SetList)

    suspend fun deleteAll()
}