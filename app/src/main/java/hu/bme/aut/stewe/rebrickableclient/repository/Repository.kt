package hu.bme.aut.stewe.rebrickableclient.repository

import hu.bme.aut.stewe.rebrickableclient.repository.datasource.LegoSetDataSource
import hu.bme.aut.stewe.rebrickableclient.repository.datasource.SetListDataSource
import hu.bme.aut.stewe.rebrickableclient.repository.datasource.UserTokenDataSource


interface Repository {
    fun userTokenData(): UserTokenDataSource

    fun setListData(): SetListDataSource

    fun legoSetsData(): LegoSetDataSource
}
