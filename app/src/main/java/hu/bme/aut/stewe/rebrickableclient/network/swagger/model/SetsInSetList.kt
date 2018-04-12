package hu.bme.aut.stewe.rebrickableclient.network.swagger.model

import com.google.gson.annotations.SerializedName
import java.util.*


data class SetsInSetList(
        @SerializedName("count")
        var count: Long? = null,

        @SerializedName("next")
        var next: String? = null,

        @SerializedName("previous")
        var previous: String? = null,

        @SerializedName("results")
        var results: List<SetListSet> = ArrayList()
)
