package hu.bme.aut.stewe.rebrickableclient.network.swagger.model

import com.google.gson.annotations.SerializedName


data class UserToken(
        var id: Long? = null,

        @SerializedName("user_token")
        var userToken: String? = null
)
