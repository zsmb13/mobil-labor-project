package hu.bme.aut.stewe.rebrickableclient.network.swagger.dto

import com.google.gson.annotations.SerializedName


data class UserToken(
        @SerializedName("user_token")
        var token: String
)