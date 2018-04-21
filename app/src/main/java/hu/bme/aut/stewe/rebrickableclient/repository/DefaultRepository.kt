package hu.bme.aut.stewe.rebrickableclient.repository

import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.SetList
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.SetListLegoSet
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.UserToken
import javax.inject.Inject


class DefaultRepository @Inject constructor(
        var userTokenData: DataSource<UserToken>,
        var setListData: DataSource<SetList>,
        var setsData: DataSource<SetListLegoSet>
) : Repository {

    override fun userTokenData(): DataSource<UserToken> = userTokenData

    override fun setListData(): DataSource<SetList> = setListData

    override fun setsData(): DataSource<SetListLegoSet> = setsData
}
