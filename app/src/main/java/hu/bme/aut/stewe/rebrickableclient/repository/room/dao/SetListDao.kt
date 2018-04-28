package hu.bme.aut.stewe.rebrickableclient.repository.room.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.SetList

@Dao
interface SetListDao {
    @Query("SELECT * FROM SetList")
    fun getAll(): List<SetList>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg items: SetList)

    @Query("DELETE FROM SetList")
    fun deleteAll()
}
