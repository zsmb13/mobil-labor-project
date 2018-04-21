package hu.bme.aut.stewe.rebrickableclient.repository

import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.SetList
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.SetListLegoSet
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.UserToken


interface Repository {
    fun userTokenData(): DataSource<UserToken>

    fun setListData(): DataSource<SetList>

    fun setsData(): DataSource<SetListLegoSet>
}
