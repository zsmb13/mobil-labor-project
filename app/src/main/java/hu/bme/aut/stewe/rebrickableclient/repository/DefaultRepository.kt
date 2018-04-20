package hu.bme.aut.stewe.rebrickableclient.repository

import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.SetList
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.SetListSet
import hu.bme.aut.stewe.rebrickableclient.repository.room.UserTokenData
import javax.inject.Inject


class DefaultRepository : Repository {

    @Inject
    lateinit var userTokenData: DataSource<UserTokenData>

    @Inject
    lateinit var setListData: DataSource<SetList>

    @Inject
    lateinit var setsData: DataSource<SetListSet>

    override fun userTokenData(): DataSource<UserTokenData> = userTokenData

    override fun setListData(): DataSource<SetList> = setListData

    override fun setsData(): DataSource<SetListSet> = setsData
}