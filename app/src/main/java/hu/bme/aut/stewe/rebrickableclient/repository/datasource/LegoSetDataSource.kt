package hu.bme.aut.stewe.rebrickableclient.repository.datasource

import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.LegoSet


interface LegoSetDataSource {
    suspend fun getAll(): List<LegoSet>

    suspend fun insertAll(vararg legoSets: LegoSet)

    suspend fun deleteAll()
}