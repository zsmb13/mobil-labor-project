package hu.bme.aut.stewe.rebrickableclient.network.swagger.model

import com.google.gson.annotations.SerializedName


data class SetListSet(
        @SerializedName("list_id")
        var listId: Long? = null,

        @SerializedName("quantity")
        var quantity: Int? = null,

        @SerializedName("include_spares")
        var includeSpares: Boolean? = null,

        @SerializedName("set")
        var set: Set<*>? = null
)
