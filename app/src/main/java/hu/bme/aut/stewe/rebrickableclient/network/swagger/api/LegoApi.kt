package hu.bme.aut.stewe.rebrickableclient.network.swagger.api


import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.Theme
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LegoApi {

    /**
     * Return details for a specific Theme
     * Return details for a specific Theme
     * @param id ID of the theme
     * @return Call<Theme>
    </Theme> */

    @GET("lego/themes/{id}/")
    fun legoThemesRead(
            @Path("id") id: Int?
    ): Call<Theme>


}
