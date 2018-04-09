package hu.bme.aut.stewe.rebrickableclient.network.swagger.model

import java.util.Objects
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

import com.google.gson.annotations.SerializedName


@ApiModel(description = "")
class UserToken {

    /**
     */
    @SerializedName("user_token")
    @get:ApiModelProperty(value = "")
    var userToken: String? = null


    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val userToken = o as UserToken?
        return userToken == userToken!!.userToken
    }

    override fun hashCode(): Int {
        return Objects.hash(userToken)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class UserToken {\n")

        sb.append("    userToken: ").append(toIndentedString(userToken)).append("\n")
        sb.append("}")
        return sb.toString()
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private fun toIndentedString(o: Any?): String {
        return o?.toString()?.replace("\n", "\n    ") ?: "null"
    }
}
