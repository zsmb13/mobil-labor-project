package hu.bme.aut.stewe.rebrickableclient.network.swagger.model

import java.util.Objects
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*

import com.google.gson.annotations.SerializedName


@ApiModel(description = "")
class SetListSet {

    /**
     */
    @SerializedName("list_id")
    @get:ApiModelProperty(value = "")
    var listId: Long? = null

    /**
     */
    @SerializedName("quantity")
    @get:ApiModelProperty(value = "")
    var quantity: Int? = null

    /**
     */
    @SerializedName("include_spares")
    @get:ApiModelProperty(value = "")
    var includeSpares: Boolean? = null

    /**
     */
    @SerializedName("set")
    @get:ApiModelProperty(value = "")
    var set: Set<*>? = null


    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val setListSet = o as SetListSet?
        return listId == setListSet!!.listId &&
                quantity == setListSet.quantity &&
                includeSpares == setListSet.includeSpares &&
                set == setListSet.set
    }

    override fun hashCode(): Int {
        return Objects.hash(listId, quantity, includeSpares, set)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class SetListSet {\n")

        sb.append("    listId: ").append(toIndentedString(listId)).append("\n")
        sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n")
        sb.append("    includeSpares: ").append(toIndentedString(includeSpares)).append("\n")
        sb.append("    set: ").append(toIndentedString(set)).append("\n")
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
