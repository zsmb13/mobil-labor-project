package hu.bme.aut.stewe.rebrickableclient.repository

import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.SetList
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.SetListSet
import hu.bme.aut.stewe.rebrickableclient.repository.room.UserTokenData


interface Repository {
    fun userTokenData(): DataSource<UserTokenData>

    fun setListData(): DataSource<SetList>

    fun setsData(): DataSource<SetListSet>
}