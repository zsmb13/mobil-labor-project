package hu.bme.aut.stewe.rebrickableclient.network.swagger.model

import com.google.gson.annotations.SerializedName


data class Theme(
        @SerializedName("id")
        var id: Long? = null,

        @SerializedName("parent_id")
        var parentId: Long? = null,

        @SerializedName("name")
        var name: String? = null
)
