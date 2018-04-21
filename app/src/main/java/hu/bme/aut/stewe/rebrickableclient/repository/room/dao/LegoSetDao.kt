package hu.bme.aut.stewe.rebrickableclient.repository.room.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.LegoSet

@Dao
interface LegoSetDao {
    @Query("SELECT * FROM LegoSet")
    fun getAll(): List<LegoSet>

    @Insert
    fun insertAll(vararg legoSets: LegoSet)

    @Query("DELETE FROM LegoSet")
    fun deleteAll()
}
