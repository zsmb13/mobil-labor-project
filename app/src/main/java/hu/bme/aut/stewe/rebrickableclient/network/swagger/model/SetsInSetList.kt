package hu.bme.aut.stewe.rebrickableclient.network.swagger.model

import com.google.gson.annotations.SerializedName
import java.util.*


class SetsInSetList {

    /**
     */
    @SerializedName("count")
    var count: Long? = null

    /**
     */
    @SerializedName("next")
    var next: String? = null

    /**
     */
    @SerializedName("previous")
    var previous: String? = null

    /**
     */
    @SerializedName("results")
    var results: List<SetListSet> = ArrayList()


    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val setsInSetList = o as SetsInSetList?
        return count == setsInSetList!!.count &&
                next == setsInSetList.next &&
                previous == setsInSetList.previous &&
                results == setsInSetList.results
    }

    override fun hashCode(): Int {
        return Objects.hash(count, next, previous, results)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class SetsInSetList {\n")

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
