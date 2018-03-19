package hu.bme.aut.stewe.rebrickableclient.network.swagger.api;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UsersApi {
  
  /**
   * Generate a User Token to be used for authorising user account actions in subsequent calls. Username can be either
   * Generate a User Token to be used for authorising user account actions in subsequent calls. Username can be either\nthe actual username or the user&#39;s email address.
   * @param username null
   * @param password null
   * @return Call<Void>
   */
  
  @FormUrlEncoded
  @POST("api/v3/users/_token/")
  Call<Void> usersTokenCreate(
          @Field("username") String username, @Field("password") String password
  );

  
  /**
   * Get a list of all the available Badges
   * Get a list of all the available Badges
   * @param page null
   * @param pageSize null
   * @param ordering null
   * @return Call<Void>
   */
  
  @GET("api/v3/users/badges/")
  Call<Void> usersBadgesList(
          @Query("page") String page, @Query("page_size") String pageSize, @Query("ordering") String ordering
  );

  
  /**
   * Get details about a specific Badge
   * Get details about a specific Badge
   * @param id null
   * @return Call<Void>
   */
  
  @GET("api/v3/users/badges/{id}/")
  Call<Void> usersBadgesRead(
          @Path("id") String id
  );

  
  /**
   * Get a list of all the Parts in all the user&#39;s Part Lists as well as the Parts inside Sets in the user&#39;s Set Lists.
   * Get a list of all the Parts in all the user&#39;s Part Lists as well as the Parts inside Sets in the user&#39;s Set Lists.\n\n###WARNING this call is very resource intensive, do not overuse it!\n\nOptionally, filter by one or more of the below query parameters.
   * @param userToken null
   * @param page null
   * @param pageSize null
   * @param partNum null
   * @param partCatId null
   * @param colorId null
   * @return Call<Void>
   */
  
  @GET("api/v3/users/{user_token}/allparts/")
  Call<Void> usersAllpartsList(
          @Path("user_token") String userToken, @Query("page") String page, @Query("page_size") String pageSize, @Query("part_num") String partNum, @Query("part_cat_id") String partCatId, @Query("color_id") String colorId
  );

  
  /**
   * Find out how many parts the user needs to build the specified Set.
   * Find out how many parts the user needs to build the specified Set.\n\nThe user&#39;s default Build Settings will be used to calculate a Build Match % using their LEGO Collection of Sets\nand Parts.
   * @param setNum null
   * @param userToken null
   * @return Call<Void>
   */
  
  @GET("api/v3/users/{user_token}/build/{set_num}/")
  Call<Void> usersBuildRead(
          @Path("set_num") String setNum, @Path("user_token") String userToken
  );

  
  /**
   * Get a list of all the Lost Parts from the user&#39;s LEGO collection.
   * Get a list of all the Lost Parts from the user&#39;s LEGO collection.\n\nOptionally, filter by one or more of the below query parameters.
   * @param userToken null
   * @param page null
   * @param pageSize null
   * @param ordering null
   * @return Call<Void>
   */
  
  @GET("api/v3/users/{user_token}/lost_parts/")
  Call<Void> usersLostPartsList(
          @Path("user_token") String userToken, @Query("page") String page, @Query("page_size") String pageSize, @Query("ordering") String ordering
  );

  
  /**
   * Add one or more Lost Parts to the user.
   * Add one or more Lost Parts to the user.\n\n### Single Part\nWhen adding a single Part, returns the successfully created Part (status 201) or details for why the Part could not\nbe added.\n### Multiple Parts\nTo add multiple Parts, POST a JSON list of them (using a Content-Type header of &#39;application/json&#39;). The inv_part_id\nfield can be retrieved from the Set&#39;s inventory.\ne.g:\n`[{\&quot;inv_part_id\&quot;: 806698, \&quot;lost_quantity\&quot;: 3},\n{\&quot;inv_part_id\&quot;: 256007, \&quot;lost_quantity\&quot;: 2}]`\nReturns a list of successfully added Parts. If the Part already exists or is unrecognised, it will be skipped.
   * @param userToken null
   * @param invPartId null
   * @param lostQuantity null
   * @return Call<Void>
   */
  
  @FormUrlEncoded
  @POST("api/v3/users/{user_token}/lost_parts/")
  Call<Void> usersLostPartsCreate(
          @Path("user_token") String userToken, @Field("inv_part_id") String invPartId, @Field("lost_quantity") String lostQuantity
  );

  
  /**
   * Remove the Lost Part from the user.
   * Remove the Lost Part from the user.
   * @param id null
   * @param userToken null
   * @return Call<Void>
   */
  
  @DELETE("api/v3/users/{user_token}/lost_parts/{id}/")
  Call<Void> usersLostPartsDelete(
          @Path("id") String id, @Path("user_token") String userToken
  );

  
  /**
   * Get a list of all the user&#39;s Part Lists.
   * Get a list of all the user&#39;s Part Lists.
   * @param userToken null
   * @param page null
   * @param pageSize null
   * @return Call<Void>
   */
  
  @GET("api/v3/users/{user_token}/partlists/")
  Call<Void> usersPartlistsList(
          @Path("user_token") String userToken, @Query("page") String page, @Query("page_size") String pageSize
  );

  
  /**
   * Add a new Part List.
   * Add a new Part List.
   * @param userToken null
   * @param name null
   * @param isBuildable null
   * @param numParts null
   * @return Call<Void>
   */
  
  @FormUrlEncoded
  @POST("api/v3/users/{user_token}/partlists/")
  Call<Void> usersPartlistsCreate(
          @Path("user_token") String userToken, @Field("name") String name, @Field("is_buildable") String isBuildable, @Field("num_parts") String numParts
  );

  
  /**
   * Get details about a specific Part List.
   * Get details about a specific Part List.
   * @param listId null
   * @param userToken null
   * @return Call<Void>
   */
  
  @GET("api/v3/users/{user_token}/partlists/{list_id}/")
  Call<Void> usersPartlistsRead(
          @Path("list_id") String listId, @Path("user_token") String userToken
  );

  
  /**
   * Replace an existing Part List&#39;s details.
   * Replace an existing Part List&#39;s details.
   * @param listId null
   * @param userToken null
   * @param name null
   * @param isBuildable null
   * @param numParts null
   * @return Call<Void>
   */
  
  @FormUrlEncoded
  @PUT("api/v3/users/{user_token}/partlists/{list_id}/")
  Call<Void> usersPartlistsUpdate(
          @Path("list_id") String listId, @Path("user_token") String userToken, @Field("name") String name, @Field("is_buildable") String isBuildable, @Field("num_parts") String numParts
  );

  
  /**
   * Delete a Part List and all it&#39;s Parts.
   * Delete a Part List and all it&#39;s Parts.
   * @param listId null
   * @param userToken null
   * @return Call<Void>
   */
  
  @DELETE("api/v3/users/{user_token}/partlists/{list_id}/")
  Call<Void> usersPartlistsDelete(
          @Path("list_id") String listId, @Path("user_token") String userToken
  );

  
  /**
   * Update an existing Part List&#39;s details.
   * Update an existing Part List&#39;s details.
   * @param listId null
   * @param userToken null
   * @param isBuildable null
   * @param name null
   * @param numParts null
   * @return Call<Void>
   */
  
  @FormUrlEncoded
  @PATCH("api/v3/users/{user_token}/partlists/{list_id}/")
  Call<Void> usersPartlistsPartialUpdate(
          @Path("list_id") String listId, @Path("user_token") String userToken, @Field("is_buildable") String isBuildable, @Field("name") String name, @Field("num_parts") String numParts
  );

  
  /**
   * Get a list of all the Parts in a specific Part List.
   * Get a list of all the Parts in a specific Part List.
   * @param listId null
   * @param userToken null
   * @param page null
   * @param pageSize null
   * @param ordering null
   * @return Call<Void>
   */
  
  @GET("api/v3/users/{user_token}/partlists/{list_id}/parts/")
  Call<Void> usersPartlistsPartsList(
          @Path("list_id") String listId, @Path("user_token") String userToken, @Query("page") String page, @Query("page_size") String pageSize, @Query("ordering") String ordering
  );

  
  /**
   * Add one or more Parts to the Part List.
   * Add one or more Parts to the Part List.\n\n### Single Part\nWhen adding a single Part, returns the successfully created Part (status 201) or details for why the Part could not\nbe added.\n### Multiple Parts\nTo add multiple Parts, POST a JSON list of them (using a Content-Type header of &#39;application/json&#39;).\ne.g:\n`[{\&quot;part_num\&quot;:\&quot;3001\&quot;, \&quot;color_id\&quot;: 1, \&quot;quantity\&quot;: 10},\n{\&quot;part_num\&quot;:\&quot;3001\&quot;, \&quot;color_id\&quot;: 2, \&quot;quantity\&quot;: 20},\n{\&quot;part_num\&quot;:\&quot;3002\&quot;, \&quot;color_id\&quot;: 14, \&quot;quantity\&quot;: 30}]`\nReturns a list of successfully added Parts. If the Part already exists or is unrecognised, it will be skipped.
   * @param listId null
   * @param userToken null
   * @param partNum null
   * @param quantity null
   * @param colorId null
   * @return Call<Void>
   */
  
  @FormUrlEncoded
  @POST("api/v3/users/{user_token}/partlists/{list_id}/parts/")
  Call<Void> usersPartlistsPartsCreate(
          @Path("list_id") String listId, @Path("user_token") String userToken, @Field("part_num") String partNum, @Field("quantity") String quantity, @Field("color_id") String colorId
  );

  
  /**
   * Get details about a specific Part in the Part List.
   * Get details about a specific Part in the Part List.
   * @param colorId null
   * @param partNum null
   * @param listId null
   * @param userToken null
   * @return Call<Void>
   */
  
  @GET("api/v3/users/{user_token}/partlists/{list_id}/parts/{part_num}/{color_id}/")
  Call<Void> usersPartlistsPartsRead(
          @Path("color_id") String colorId, @Path("part_num") String partNum, @Path("list_id") String listId, @Path("user_token") String userToken
  );

  
  /**
   * Replace an existing Part&#39;s details in the Part List.
   * Replace an existing Part&#39;s details in the Part List.
   * @param colorId null
   * @param partNum null
   * @param listId null
   * @param userToken null
   * @param quantity null
   * @return Call<Void>
   */
  
  @FormUrlEncoded
  @PUT("api/v3/users/{user_token}/partlists/{list_id}/parts/{part_num}/{color_id}/")
  Call<Void> usersPartlistsPartsUpdate(
          @Path("color_id") String colorId, @Path("part_num") String partNum, @Path("list_id") String listId, @Path("user_token") String userToken, @Field("quantity") String quantity
  );

  
  /**
   * Delete a Part from the Part List.
   * Delete a Part from the Part List.
   * @param colorId null
   * @param partNum null
   * @param listId null
   * @param userToken null
   * @return Call<Void>
   */
  
  @DELETE("api/v3/users/{user_token}/partlists/{list_id}/parts/{part_num}/{color_id}/")
  Call<Void> usersPartlistsPartsDelete(
          @Path("color_id") String colorId, @Path("part_num") String partNum, @Path("list_id") String listId, @Path("user_token") String userToken
  );

  
  /**
   * Get a list of all the Parts in all the user&#39;s Part Lists.
   * Get a list of all the Parts in all the user&#39;s Part Lists.\n\n###Set List logic\nParts appearing in multiple Part Lists will be listed multiple times.\n\nOptionally, filter by one or more of the below query parameters.
   * @param userToken null
   * @param page null
   * @param pageSize null
   * @param partNum null
   * @param partCatId null
   * @param colorId null
   * @param ordering null
   * @param search null
   * @return Call<Void>
   */
  
  @GET("api/v3/users/{user_token}/parts/")
  Call<Void> usersPartsList(
          @Path("user_token") String userToken, @Query("page") String page, @Query("page_size") String pageSize, @Query("part_num") String partNum, @Query("part_cat_id") String partCatId, @Query("color_id") String colorId, @Query("ordering") String ordering, @Query("search") String search
  );

  
  /**
   * Get details about a specific user.
   * Get details about a specific user.
   * @param userToken null
   * @param page null
   * @param pageSize null
   * @return Call<Void>
   */
  
  @GET("api/v3/users/{user_token}/profile/")
  Call<Void> usersProfileList(
          @Path("user_token") String userToken, @Query("page") String page, @Query("page_size") String pageSize
  );

  
  /**
   * Get a list of all the user&#39;s Set Lists.
   * Get a list of all the user&#39;s Set Lists.
   * @param userToken null
   * @param page null
   * @param pageSize null
   * @return Call<Void>
   */
  
  @GET("api/v3/users/{user_token}/setlists/")
  Call<Void> usersSetlistsList(
          @Path("user_token") String userToken, @Query("page") String page, @Query("page_size") String pageSize
  );

  
  /**
   * Add a new Set List.
   * Add a new Set List.
   * @param userToken null
   * @param name null
   * @param isBuildable null
   * @param numSets null
   * @return Call<Void>
   */
  
  @FormUrlEncoded
  @POST("api/v3/users/{user_token}/setlists/")
  Call<Void> usersSetlistsCreate(
          @Path("user_token") String userToken, @Field("name") String name, @Field("is_buildable") String isBuildable, @Field("num_sets") String numSets
  );

  
  /**
   * Get details about a specific Set List.
   * Get details about a specific Set List.
   * @param listId null
   * @param userToken null
   * @return Call<Void>
   */
  
  @GET("api/v3/users/{user_token}/setlists/{list_id}/")
  Call<Void> usersSetlistsRead(
          @Path("list_id") String listId, @Path("user_token") String userToken
  );

  
  /**
   * Replace an existing Set List&#39;s details.
   * Replace an existing Set List&#39;s details.
   * @param listId null
   * @param userToken null
   * @param name null
   * @param isBuildable null
   * @param numSets null
   * @return Call<Void>
   */
  
  @FormUrlEncoded
  @PUT("api/v3/users/{user_token}/setlists/{list_id}/")
  Call<Void> usersSetlistsUpdate(
          @Path("list_id") String listId, @Path("user_token") String userToken, @Field("name") String name, @Field("is_buildable") String isBuildable, @Field("num_sets") String numSets
  );

  
  /**
   * Delete a Set List and all it&#39;s Sets.
   * Delete a Set List and all it&#39;s Sets.
   * @param listId null
   * @param userToken null
   * @return Call<Void>
   */
  
  @DELETE("api/v3/users/{user_token}/setlists/{list_id}/")
  Call<Void> usersSetlistsDelete(
          @Path("list_id") String listId, @Path("user_token") String userToken
  );

  
  /**
   * Update an existing Set List&#39;s details.
   * Update an existing Set List&#39;s details.
   * @param listId null
   * @param userToken null
   * @param isBuildable null
   * @param name null
   * @param numSets null
   * @return Call<Void>
   */
  
  @FormUrlEncoded
  @PATCH("api/v3/users/{user_token}/setlists/{list_id}/")
  Call<Void> usersSetlistsPartialUpdate(
          @Path("list_id") String listId, @Path("user_token") String userToken, @Field("is_buildable") String isBuildable, @Field("name") String name, @Field("num_sets") String numSets
  );

  
  /**
   * Get a list of all the Sets in a specific Set List.
   * Get a list of all the Sets in a specific Set List.
   * @param listId null
   * @param userToken null
   * @param page null
   * @param pageSize null
   * @param ordering null
   * @return Call<Void>
   */
  
  @GET("api/v3/users/{user_token}/setlists/{list_id}/sets/")
  Call<Void> usersSetlistsSetsList(
          @Path("list_id") String listId, @Path("user_token") String userToken, @Query("page") String page, @Query("page_size") String pageSize, @Query("ordering") String ordering
  );

  
  /**
   * Add one or more Sets to the Set List. Existing Sets are unaffected.
   * Add one or more Sets to the Set List. Existing Sets are unaffected.\n\n### Single Set\nWhen adding a single Set, returns the successfully created Set (status 201) or details for why the Set could not\nbe added.\n### Multiple Sets\nTo add multiple Sets, POST a JSON list of them (using a Content-Type header of &#39;application/json&#39;).\ne.g:\n`[{\&quot;set_num\&quot;:\&quot;8043-1\&quot;, \&quot;quantity\&quot;: 1},\n{\&quot;set_num\&quot;:\&quot;8110-1\&quot;, \&quot;quantity\&quot;: 2, \&quot;include_spares\&quot;: \&quot;False\&quot;}]`\nReturns a list of successfully added Sets. If the Set already exists or is unrecognised, it will be skipped.
   * @param listId null
   * @param userToken null
   * @param setNum null
   * @param quantity null
   * @param includeSpares null
   * @return Call<Void>
   */
  
  @FormUrlEncoded
  @POST("api/v3/users/{user_token}/setlists/{list_id}/sets/")
  Call<Void> usersSetlistsSetsCreate(
          @Path("list_id") String listId, @Path("user_token") String userToken, @Field("set_num") String setNum, @Field("quantity") String quantity, @Field("include_spares") String includeSpares
  );

  
  /**
   * Get details about a specific Set in the Set List.
   * Get details about a specific Set in the Set List.
   * @param setNum null
   * @param listId null
   * @param userToken null
   * @return Call<Void>
   */
  
  @GET("api/v3/users/{user_token}/setlists/{list_id}/sets/{set_num}/")
  Call<Void> usersSetlistsSetsRead(
          @Path("set_num") String setNum, @Path("list_id") String listId, @Path("user_token") String userToken
  );

  
  /**
   * Replace an existing Set&#39;s details in the Set List.
   * Replace an existing Set&#39;s details in the Set List.
   * @param setNum null
   * @param listId null
   * @param userToken null
   * @param quantity null
   * @param includeSpares null
   * @return Call<Void>
   */
  
  @FormUrlEncoded
  @PUT("api/v3/users/{user_token}/setlists/{list_id}/sets/{set_num}/")
  Call<Void> usersSetlistsSetsUpdate(
          @Path("set_num") String setNum, @Path("list_id") String listId, @Path("user_token") String userToken, @Field("quantity") String quantity, @Field("include_spares") String includeSpares
  );

  
  /**
   * Delete a Set from the Set List.
   * Delete a Set from the Set List.
   * @param setNum null
   * @param listId null
   * @param userToken null
   * @return Call<Void>
   */
  
  @DELETE("api/v3/users/{user_token}/setlists/{list_id}/sets/{set_num}/")
  Call<Void> usersSetlistsSetsDelete(
          @Path("set_num") String setNum, @Path("list_id") String listId, @Path("user_token") String userToken
  );

  
  /**
   * Update an existing Set&#39;s details in the Set List.
   * Update an existing Set&#39;s details in the Set List.
   * @param setNum null
   * @param listId null
   * @param userToken null
   * @param quantity null
   * @param includeSpares null
   * @return Call<Void>
   */
  
  @FormUrlEncoded
  @PATCH("api/v3/users/{user_token}/setlists/{list_id}/sets/{set_num}/")
  Call<Void> usersSetlistsSetsPartialUpdate(
          @Path("set_num") String setNum, @Path("list_id") String listId, @Path("user_token") String userToken, @Field("quantity") String quantity, @Field("include_spares") String includeSpares
  );

  
  /**
   * Get a list of all the Sets in the user&#39;s LEGO collection.
   * Get a list of all the Sets in the user&#39;s LEGO collection.\n\n### Set List logic\nSets appearing in multiple Set Lists will be listed multiple times.\n\nOptionally, filter by one or more of the below query parameters.
   * @param userToken null
   * @param page null
   * @param pageSize null
   * @param setNum null
   * @param themeId null
   * @param minYear null
   * @param maxYear null
   * @param minParts null
   * @param maxParts null
   * @param ordering null
   * @param search null
   * @return Call<Void>
   */
  
  @GET("api/v3/users/{user_token}/sets/")
  Call<Void> usersSetsList(
          @Path("user_token") String userToken, @Query("page") String page, @Query("page_size") String pageSize, @Query("set_num") String setNum, @Query("theme_id") String themeId, @Query("min_year") String minYear, @Query("max_year") String maxYear, @Query("min_parts") String minParts, @Query("max_parts") String maxParts, @Query("ordering") String ordering, @Query("search") String search
  );

  
  /**
   * Add one or more Sets to the user&#39;s LEGO collection. Existing Sets are unaffected.
   * Add one or more Sets to the user&#39;s LEGO collection. Existing Sets are unaffected.\n\n### Set List logic\nThe Set List used when adding sets is chosen in the following order:\n1. If no Set Lists exist, one will be created and used\n2. User&#39;s configured default Set List for Imports\n3. The first Set List alphabetically\n\n### Single Set\nWhen adding a single Set, returns the successfully created Set (status 201) or details for why the Set could not\nbe added.\n### Multiple Sets\nTo add multiple Sets, POST a JSON list of them (using a Content-Type header of &#39;application/json&#39;).\ne.g:\n`[{\&quot;set_num\&quot;:\&quot;8043-1\&quot;, \&quot;quantity\&quot;: 1},\n{\&quot;set_num\&quot;:\&quot;8110-1\&quot;, \&quot;quantity\&quot;: 2, \&quot;include_spares\&quot;: \&quot;False\&quot;}]`\nReturns a list of successfully added Sets. If the Set already exists or is unrecognised, it will be skipped.
   * @param userToken null
   * @param setNum null
   * @param quantity null
   * @param includeSpares null
   * @return Call<Void>
   */
  
  @FormUrlEncoded
  @POST("api/v3/users/{user_token}/sets/")
  Call<Void> usersSetsCreate(
          @Path("user_token") String userToken, @Field("set_num") String setNum, @Field("quantity") String quantity, @Field("include_spares") String includeSpares
  );

  
  /**
   * Synchronise a user&#39;s Sets to the POSTed list.
   * Synchronise a user&#39;s Sets to the POSTed list.\n\n### Set List logic\nThis is used to completely replace the user&#39;s Sets with those in the supplied list.\nIt will remove any Sets in Rebrickable that are not found in the supplied list.\nIt will attempt to keep any current Rebrickable Sets in their existing Set Lists, and will add any new Sets\nfound into the Default Set List for Imports in the user&#39;s settings.\n### Single Set\nWhen adding a single Set, returns the successfully created Set (status 201) or details for why the Set could not\nbe added.\n### Multiple Sets\nTo add multiple Sets, POST a JSON list of them (using a Content-Type header of &#39;application/json&#39;).\ne.g:\n`[{\&quot;set_num\&quot;:\&quot;8043-1\&quot;, \&quot;quantity\&quot;: 1},\n{\&quot;set_num\&quot;:\&quot;8110-1\&quot;, \&quot;quantity\&quot;: 2, \&quot;include_spares\&quot;: \&quot;False\&quot;}]`\nReturns a list of successfully added Sets. If the Set is unrecognised, it will be skipped.
   * @param userToken null
   * @param setNum null
   * @param quantity null
   * @param includeSpares null
   * @return Call<Void>
   */
  
  @FormUrlEncoded
  @POST("api/v3/users/{user_token}/sets/sync/")
  Call<Void> usersSetsSyncCreate(
          @Path("user_token") String userToken, @Field("set_num") String setNum, @Field("quantity") String quantity, @Field("include_spares") String includeSpares
  );

  
  /**
   * Get details about a specific Set in the user&#39;s LEGO collection.
   * Get details about a specific Set in the user&#39;s LEGO collection.\n\n### Set List logic\nBecause this merges sets found across all Set Lists the fields list_id and include_spares may not be\naccurate unless the Set actually only exists in a single Set List.
   * @param setNum null
   * @param userToken null
   * @return Call<Void>
   */
  
  @GET("api/v3/users/{user_token}/sets/{set_num}/")
  Call<Void> usersSetsRead(
          @Path("set_num") String setNum, @Path("user_token") String userToken
  );

  
  /**
   * Update an existing Set&#39;s quantity in all Set Lists. This PUT call is different to others in that it will create
   * Update an existing Set&#39;s quantity in all Set Lists. This PUT call is different to others in that it will create\nthe Set if it doesn&#39;t already exist, and it will delete the Set if you pass a quantity of 0.\n\n### Set List logic\n* Default Set List = user&#39;s configured default import list or the first alphabetically if none exist.\n* Increasing quantity = add to Set in default Set List if it exists, else add it there\n* Decreasing quantity = remove from Set in default Set List first, then from remaining lists until done
   * @param setNum null
   * @param userToken null
   * @param quantity null
   * @return Call<Void>
   */
  
  @FormUrlEncoded
  @PUT("api/v3/users/{user_token}/sets/{set_num}/")
  Call<Void> usersSetsUpdate(
          @Path("set_num") String setNum, @Path("user_token") String userToken, @Field("quantity") String quantity
  );

  
  /**
   * Delete the Set from all the user&#39;s Set Lists.
   * Delete the Set from all the user&#39;s Set Lists.
   * @param setNum null
   * @param userToken null
   * @return Call<Void>
   */
  
  @DELETE("api/v3/users/{user_token}/sets/{set_num}/")
  Call<Void> usersSetsDelete(
          @Path("set_num") String setNum, @Path("user_token") String userToken
  );

  
}
