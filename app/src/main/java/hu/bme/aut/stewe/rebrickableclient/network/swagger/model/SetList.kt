package hu.bme.aut.stewe.rebrickableclient.network.swagger.model

import com.google.gson.annotations.SerializedName


class SetList {

    @SerializedName("id")
    var id: Long? = null

    @SerializedName("is_buildable")
    var isBuildable: Boolean? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("num_sets")
    var numSets: Int? = null

}
