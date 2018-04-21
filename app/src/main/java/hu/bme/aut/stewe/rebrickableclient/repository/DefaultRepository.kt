package hu.bme.aut.stewe.rebrickableclient.repository

import hu.bme.aut.stewe.rebrickableclient.repository.datasource.LegoSetDataSource
import hu.bme.aut.stewe.rebrickableclient.repository.datasource.SetListDataSource
import hu.bme.aut.stewe.rebrickableclient.repository.datasource.UserTokenDataSource
import javax.inject.Inject


class DefaultRepository @Inject constructor(
        private var userTokenData: UserTokenDataSource,
        private var setListData: SetListDataSource,
        private var legoSetsData: LegoSetDataSource
) : Repository {
    override fun userTokenData(): UserTokenDataSource = userTokenData

    override fun setListData(): SetListDataSource = setListData

    override fun setsData(): LegoSetDataSource = legoSetsData
}
