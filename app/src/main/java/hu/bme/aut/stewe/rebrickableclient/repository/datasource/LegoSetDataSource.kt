package hu.bme.aut.stewe.rebrickableclient.repository.datasource

import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.LegoSet


interface LegoSetDataSource {
    fun getAll(): List<LegoSet>

    fun insertAll(vararg legoSets: LegoSet)

    fun deleteAll()
}