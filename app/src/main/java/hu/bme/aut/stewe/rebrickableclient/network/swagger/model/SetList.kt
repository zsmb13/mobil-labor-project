package hu.bme.aut.stewe.rebrickableclient.network.swagger.model

import java.util.Objects
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

import com.google.gson.annotations.SerializedName


@ApiModel(description = "")
class SetList {

    /**
     */
    @SerializedName("id")
    @get:ApiModelProperty(value = "")
    var id: Long? = null

    /**
     */
    @SerializedName("is_buildable")
    @get:ApiModelProperty(value = "")
    var isBuildable: Boolean? = null

    /**
     */
    @SerializedName("name")
    @get:ApiModelProperty(value = "")
    var name: String? = null

    /**
     */
    @SerializedName("num_sets")
    @get:ApiModelProperty(value = "")
    var numSets: Int? = null


    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val setList = o as SetList?
        return id == setList!!.id &&
                isBuildable == setList.isBuildable &&
                name == setList.name &&
                numSets == setList.numSets
    }

    override fun hashCode(): Int {
        return Objects.hash(id, isBuildable, name, numSets)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class SetList {\n")

        sb.append("    id: ").append(toIndentedString(id)).append("\n")
        sb.append("    isBuildable: ").append(toIndentedString(isBuildable)).append("\n")
        sb.append("    name: ").append(toIndentedString(name)).append("\n")
        sb.append("    numSets: ").append(toIndentedString(numSets)).append("\n")
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
