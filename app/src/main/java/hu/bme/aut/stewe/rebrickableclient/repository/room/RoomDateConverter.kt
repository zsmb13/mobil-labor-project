package hu.bme.aut.stewe.rebrickableclient.repository.room

import android.arch.persistence.room.TypeConverter
import java.util.*


class RoomDateConverter {

    @TypeConverter
    fun toDate(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun toLong(value: Date?): Long? {
        return (value?.time)
    }
}