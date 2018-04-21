package hu.bme.aut.stewe.rebrickableclient.repository.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.LegoSet
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.SetList
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.UserToken
import hu.bme.aut.stewe.rebrickableclient.repository.room.dao.LegoSetDao
import hu.bme.aut.stewe.rebrickableclient.repository.room.dao.SetListDao
import hu.bme.aut.stewe.rebrickableclient.repository.room.dao.UserTokenDao

@Database(entities = [UserToken::class, SetList::class, LegoSet::class], version = 1)
@TypeConverters(RoomDateConverter::class)
abstract class RoomUnbrickableDatabase :RoomDatabase(){
    abstract fun userTokenDao() : UserTokenDao
    abstract fun setListDao() : SetListDao
    abstract fun legoSetDao() : LegoSetDao
}