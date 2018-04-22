package hu.bme.aut.stewe.rebrickableclient.repository.room.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.UserToken

@Dao
abstract class UserTokenDao {
    @Query("SELECT userToken FROM UserToken WHERE id = 1")
    abstract fun getUserToken(): String?

    @Insert
    abstract fun saveUserToken(userToken: UserToken)

    @Query("DELETE FROM UserToken WHERE id=1")
    abstract fun deleteUserToken()

    fun saveUserToken(token: String) {
        saveUserToken(UserToken(1, token))
    }
}
