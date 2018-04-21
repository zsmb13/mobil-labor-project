package hu.bme.aut.stewe.rebrickableclient.network.swagger.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull
import com.google.gson.annotations.SerializedName

@Entity
class SetList {
    @SerializedName("id")
    @PrimaryKey
    @NonNull
    var id: Long? = null

    @SerializedName("is_buildable")
    var isBuildable: Boolean? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("num_sets")
    var numSets: Int? = null
}
