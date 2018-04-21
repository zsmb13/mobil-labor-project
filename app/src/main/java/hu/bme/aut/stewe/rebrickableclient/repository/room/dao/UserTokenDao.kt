package hu.bme.aut.stewe.rebrickableclient.repository.room.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query

@Dao
interface UserTokenDao {
    @Query("SELECT userToken FROM UserToken WHERE id = 1")
    fun getUserToken(): String

    @Query("INSERT INTO UserToken VALUES (1,(:token))")
    fun saveUserToken(token: String)

    @Query("DELETE FROM UserToken WHERE id=1")
    fun deleteUserToken()
}
