package hu.bme.aut.stewe.rebrickableclient.network.swagger.model

import com.google.gson.annotations.SerializedName


data class UserToken(
        @SerializedName("user_token")
        var userToken: String? = null
)

