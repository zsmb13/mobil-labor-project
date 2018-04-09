package hu.bme.aut.stewe.rebrickableclient.network.swagger.model

import java.util.Objects
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

import com.google.gson.annotations.SerializedName


@ApiModel(description = "")
class Theme {

    /**
     */
    @SerializedName("id")
    @get:ApiModelProperty(value = "")
    var id: Long? = null

    /**
     */
    @SerializedName("parent_id")
    @get:ApiModelProperty(value = "")
    var parentId: Long? = null

    /**
     */
    @SerializedName("name")
    @get:ApiModelProperty(value = "")
    var name: String? = null


    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val theme = o as Theme?
        return id == theme!!.id &&
                parentId == theme.parentId &&
                name == theme.name
    }

    override fun hashCode(): Int {
        return Objects.hash(id, parentId, name)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class Theme {\n")

        sb.append("    id: ").append(toIndentedString(id)).append("\n")
        sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n")
        sb.append("    name: ").append(toIndentedString(name)).append("\n")
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
