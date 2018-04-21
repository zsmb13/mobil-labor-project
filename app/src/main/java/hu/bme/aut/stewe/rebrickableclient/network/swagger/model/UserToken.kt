package hu.bme.aut.stewe.rebrickableclient.network.swagger.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class UserToken(
        @PrimaryKey
        var id: Long? = null,

        @SerializedName("user_token")
        var userToken: String? = null
)
