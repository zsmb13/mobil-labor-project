package hu.bme.aut.stewe.rebrickableclient.network.swagger.model

import java.util.Objects
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import io.swagger.client.model.SetList
import java.util.ArrayList

import com.google.gson.annotations.SerializedName


@ApiModel(description = "")
class SetLists {

    /**
     */
    @SerializedName("count")
    @get:ApiModelProperty(value = "")
    var count: Long? = null

    /**
     */
    @SerializedName("next")
    @get:ApiModelProperty(value = "")
    var next: String? = null

    /**
     */
    @SerializedName("previous")
    @get:ApiModelProperty(value = "")
    var previous: String? = null

    /**
     */
    @SerializedName("results")
    @get:ApiModelProperty(value = "")
    var results: List<SetList> = ArrayList()


    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val setLists = o as SetLists?
        return count == setLists!!.count &&
                next == setLists.next &&
                previous == setLists.previous &&
                results == setLists.results
    }

    override fun hashCode(): Int {
        return Objects.hash(count, next, previous, results)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class SetLists {\n")

        sb.append("    count: ").append(toIndentedString(count)).append("\n")
        sb.append("    next: ").append(toIndentedString(next)).append("\n")
        sb.append("    previous: ").append(toIndentedString(previous)).append("\n")
        sb.append("    results: ").append(toIndentedString(results)).append("\n")
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
