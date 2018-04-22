package hu.bme.aut.stewe.rebrickableclient.network.swagger.api


import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.*
import retrofit2.Call
import retrofit2.http.*

interface UsersApi {

    /**
     * Generate a User Token to be used for authorising user account actions in subsequent calls. Username can be either
     * Generate a User Token to be used for authorising user account actions in subsequent calls. Username can be either\nthe actual username or the user&#39;s email address.
     * @param username
     * @param password
     * @return Call<UserToken>
    </UserToken> */

    @FormUrlEncoded
    @POST("users/_token/")
    fun usersTokenCreate(
            @Field("username") username: String, @Field("password") password: String
    ): Call<UserToken>


    /**
     * Get a list of all the user&#39;s Set Lists.
     * Get a list of all the user&#39;s Set Lists.
     * @param userToken
     * @param page
     * @param pageSize
     * @return Call<SetLists>
    </SetLists> */

    @GET("users/{user_token}/setlists/")
    fun usersSetlistsList(
            @Path("user_token") userToken: String, @Query("page") page: Int?, @Query("page_size") pageSize: Int?
    ): Call<SetLists>


    /**
     * Add a new Set List.
     * Add a new Set List.
     * @param userToken
     * @param name
     * @param isBuildable
     * @param numSets
     * @return Call<SetList>
    </SetList> */

    @FormUrlEncoded
    @POST("users/{user_token}/setlists/")
    fun usersSetlistsCreate(
            @Path("user_token") userToken: String, @Field("name") name: String, @Field("is_buildable") isBuildable: String,
            @Field("num_sets") numSets: Int?
    ): Call<SetList>


    /**
     * Get details about a specific Set List.
     * Get details about a specific Set List.
     * @param listId
     * @param userToken
     * @return Call<SetList>
    </SetList> */

    @GET("users/{user_token}/setlists/{list_id}/")
    fun usersSetlistsRead(
            @Path("list_id") listId: Int?, @Path("user_token") userToken: String
    ): Call<SetList>


    /**
     * Replace an existing Set List&#39;s details.
     * Replace an existing Set List&#39;s details.
     * @param listId
     * @param userToken
     * @param name
     * @param isBuildable
     * @param numSets
     * @return Call<Void>
    </Void> */

    @FormUrlEncoded
    @PUT("users/{user_token}/setlists/{list_id}/")
    fun usersSetlistsUpdate(
            @Path("list_id") listId: Int?, @Path("user_token") userToken: String, @Field("name") name: String,
            @Field("is_buildable") isBuildable: String, @Field("num_sets") numSets: Int?
    ): Call<Void>


    /**
     * Delete a Set List and all it&#39;s Sets.
     * Delete a Set List and all it&#39;s Sets.
     * @param listId
     * @param userToken
     * @return Call<Void>
    </Void> */

    @DELETE("users/{user_token}/setlists/{list_id}/")
    fun usersSetlistsDelete(
            @Path("list_id") listId: Int?, @Path("user_token") userToken: String
    ): Call<Void>


    /**
     * Update an existing Set List&#39;s details.
     * Update an existing Set List&#39;s details.
     * @param listId
     * @param userToken
     * @param isBuildable
     * @param name
     * @param numSets
     * @return Call<Void>
    </Void> */

    @FormUrlEncoded
    @PATCH("users/{user_token}/setlists/{list_id}/")
    fun usersSetlistsPartialUpdate(
            @Path("list_id") listId: Int?, @Path("user_token") userToken: String,
            @Field("is_buildable") isBuildable: String, @Field("name") name: String, @Field("num_sets") numSets: Int?
    ): Call<Void>


    /**
     * Get a list of all the Sets in a specific Set List.
     * Get a list of all the Sets in a specific Set List.
     * @param listId
     * @param userToken
     * @param page
     * @param pageSize
     * @param ordering
     * @return Call<LegoSetsInSetList>
    </LegoSetsInSetList> */

    @GET("users/{user_token}/setlists/{list_id}/sets/")
    fun usersSetlistsSetsList(
            @Path("list_id") listId: Long?, @Path("user_token") userToken: String, @Query("page") page: Int?,
            @Query("page_size") pageSize: Int?, @Query("ordering") ordering: String
    ): Call<LegoSetsInSetList>


    /**
     * Add one or more Sets to the Set List. Existing Sets are unaffected.
     * Add one or more Sets to the Set List. Existing Sets are unaffected.\n\n### Single Set\nWhen adding a single Set, returns the successfully created Set (status 201) or details for why the Set could not\nbe added.\n### Multiple Sets\nTo add multiple Sets, POST a JSON list of them (using a Content-Type header of &#39;application/json&#39;).\ne.g:\n`[{\&quot;set_num\&quot;:\&quot;8043-1\&quot;, \&quot;quantity\&quot;: 1},\n{\&quot;set_num\&quot;:\&quot;8110-1\&quot;, \&quot;quantity\&quot;: 2, \&quot;include_spares\&quot;: \&quot;False\&quot;}]`\nReturns a list of successfully added Sets. If the Set already exists or is unrecognised, it will be skipped.
     * @param listId
     * @param userToken
     * @param setNum
     * @param quantity
     * @param includeSpares
     * @return Call<Void>
    </Void> */

    @FormUrlEncoded
    @POST("users/{user_token}/setlists/{list_id}/sets/")
    fun usersSetlistsSetsCreate(
            @Path("list_id") listId: Long?, @Path("user_token") userToken: String, @Field("set_num") setNum: String,
            @Field("quantity") quantity: Int?, @Field("include_spares") includeSpares: String
    ): Call<Void>


    /**
     * Get details about a specific Set in the Set List.
     * Get details about a specific Set in the Set List.
     * @param setNum
     * @param listId
     * @param userToken
     * @return Call<LegoSet>
    </LegoSet> */

    @GET("users/{user_token}/setlists/{list_id}/sets/{set_num}/")
    fun usersSetlistsSetsRead(
            @Path("set_num") setNum: String, @Path("list_id") listId: Int?, @Path("user_token") userToken: String
    ): Call<LegoSet>


    /**
     * Replace an existing Set&#39;s details in the Set List.
     * Replace an existing Set&#39;s details in the Set List.
     * @param setNum
     * @param listId
     * @param userToken
     * @param quantity
     * @param includeSpares
     * @return Call<Void>
    </Void> */

    @FormUrlEncoded
    @PUT("users/{user_token}/setlists/{list_id}/sets/{set_num}/")
    fun usersSetlistsSetsUpdate(
            @Path("set_num") setNum: String, @Path("list_id") listId: String, @Path("user_token") userToken: String,
            @Field("quantity") quantity: String, @Field("include_spares") includeSpares: String
    ): Call<Void>


    /**
     * Delete a Set from the Set List.
     * Delete a Set from the Set List.
     * @param setNum
     * @param listId
     * @param userToken
     * @return Call<Void>
    </Void> */

    @DELETE("users/{user_token}/setlists/{list_id}/sets/{set_num}/")
    fun usersSetlistsSetsDelete(
            @Path("set_num") setNum: String, @Path("list_id") listId: String, @Path("user_token") userToken: String
    ): Call<Void>


    /**
     * Update an existing Set&#39;s details in the Set List.
     * Update an existing Set&#39;s details in the Set List.
     * @param setNum
     * @param listId
     * @param userToken
     * @param quantity
     * @param includeSpares
     * @return Call<Void>
    </Void> */

    @FormUrlEncoded
    @PATCH("users/{user_token}/setlists/{list_id}/sets/{set_num}/")
    fun usersSetlistsSetsPartialUpdate(
            @Path("set_num") setNum: String, @Path("list_id") listId: String, @Path("user_token") userToken: String,
            @Field("quantity") quantity: String, @Field("include_spares") includeSpares: String
    ): Call<Void>


    /**
     * Get details about a specific Set in the user&#39;s LEGO collection.
     * Get details about a specific Set in the user&#39;s LEGO collection.\n\n### Set List logic\nBecause this merges sets found across all Set Lists the fields list_id and include_spares may not be\naccurate unless the Set actually only exists in a single Set List.
     * @param setNum
     * @param userToken
     * @return Call<LegoSet>
    </LegoSet> */

    @GET("users/{user_token}/sets/{set_num}/")
    fun usersSetsRead(
            @Path("set_num") setNum: String, @Path("user_token") userToken: String
    ): Call<LegoSet>


    /**
     * Update an existing Set&#39;s quantity in all Set Lists. This PUT call is different to others in that it will create
     * Update an existing Set&#39;s quantity in all Set Lists. This PUT call is different to others in that it will create\nthe Set if it doesn&#39;t already exist, and it will delete the Set if you pass a quantity of 0.\n\n### Set List logic\n* Default Set List = user&#39;s configured default import list or the first alphabetically if none exist.\n* Increasing quantity = add to Set in default Set List if it exists, else add it there\n* Decreasing quantity = remove from Set in default Set List first, then from remaining lists until done
     * @param setNum
     * @param userToken
     * @param quantity
     * @return Call<Void>
    </Void> */

    @FormUrlEncoded
    @PUT("users/{user_token}/sets/{set_num}/")
    fun usersSetsUpdate(
            @Path("set_num") setNum: String, @Path("user_token") userToken: String, @Field("quantity") quantity: Int?
    ): Call<Void>


    /**
     * Delete the Set from all the user&#39;s Set Lists.
     * Delete the Set from all the user&#39;s Set Lists.
     * @param setNum
     * @param userToken
     * @return Call<Void>
    </Void> */

    @DELETE("users/{user_token}/sets/{set_num}/")
    fun usersSetsDelete(
            @Path("set_num") setNum: String, @Path("user_token") userToken: String
    ): Call<Void>


}
