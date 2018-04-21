package hu.bme.aut.stewe.rebrickableclient.network.swagger.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity
data class LegoSet(
        @SerializedName("set_num")
        @PrimaryKey
        var setNum: String,

        @SerializedName("name")
        var name: String? = null,

        @SerializedName("year")
        var year: Int? = null,

        @SerializedName("theme_id")
        var themeId: Long? = null,

        @SerializedName("num_parts")
        var numParts: Int? = null,

        @SerializedName("set_img_url")
        var setImgUrl: String? = null,

        @SerializedName("set_url")
        var setUrl: String? = null,

        @SerializedName("last_modified_dt")
        var lastModifiedDt: Date? = null
)

