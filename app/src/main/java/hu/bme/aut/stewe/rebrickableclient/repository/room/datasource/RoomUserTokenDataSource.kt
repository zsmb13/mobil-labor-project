package hu.bme.aut.stewe.rebrickableclient.repository.room.datasource

import hu.bme.aut.stewe.rebrickableclient.repository.datasource.UserTokenDataSource
import hu.bme.aut.stewe.rebrickableclient.repository.room.RoomUnbrickableDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomUserTokenDataSource @Inject constructor(
        private var appDatabase: RoomUnbrickableDatabase
) : UserTokenDataSource {
    override suspend fun getUserToken(): String? = appDatabase.userTokenDao().getUserToken()

    override suspend fun saveUserToken(token: String) = appDatabase.userTokenDao().saveUserToken(token)

    override suspend fun deleteUserToken() = appDatabase.userTokenDao().deleteUserToken()
}