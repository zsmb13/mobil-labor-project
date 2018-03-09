package hu.bme.aut.stewe.rebrickableclient.network.swagger.api;

import io.swagger.client.CollectionFormats.*;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface LegoApi {
  
  /**
   * Get a list of all Colors.
   * Get a list of all Colors.
   * @param page null
   * @param pageSize null
   * @param ordering null
   * @return Call<Void>
   */
  
  @GET("api/v3/lego/colors/")
  Call<Void> legoColorsList(
          @Query("page") String page, @Query("page_size") String pageSize, @Query("ordering") String ordering
  );

  
  /**
   * Get details about a specific Color.
   * Get details about a specific Color.
   * @param id null
   * @return Call<Void>
   */
  
  @GET("api/v3/lego/colors/{id}/")
  Call<Void> legoColorsRead(
          @Path("id") String id
  );

  
  /**
   * Get details about a specific Element ID.
   * Get details about a specific Element ID.
   * @param elementId null
   * @return Call<Void>
   */
  
  @GET("api/v3/lego/elements/{element_id}/")
  Call<Void> legoElementsRead(
          @Path("element_id") String elementId
  );

  
  /**
   * Get details for a specific MOC.
   * Get details for a specific MOC.
   * @param setNum null
   * @return Call<Void>
   */
  
  @GET("api/v3/lego/mocs/{set_num}/")
  Call<Void> legoMocsRead(
          @Path("set_num") String setNum
  );

  
  /**
   * Get a list of all Inventory Parts in this MOC.
   * Get a list of all Inventory Parts in this MOC.
   * @param setNum null
   * @param page null
   * @param pageSize null
   * @return Call<Void>
   */
  
  @GET("api/v3/lego/mocs/{set_num}/parts/")
  Call<Void> legoMocsPartsList(
          @Path("set_num") String setNum, @Query("page") String page, @Query("page_size") String pageSize
  );

  
  /**
   * Get a list of all Part Categories.
   * Get a list of all Part Categories.
   * @param page null
   * @param pageSize null
   * @param ordering null
   * @return Call<Void>
   */
  
  @GET("api/v3/lego/part_categories/")
  Call<Void> legoPartCategoriesList(
          @Query("page") String page, @Query("page_size") String pageSize, @Query("ordering") String ordering
  );

  
  /**
   * Get details about a specific Part Category.
   * Get details about a specific Part Category.
   * @param id null
   * @return Call<Void>
   */
  
  @GET("api/v3/lego/part_categories/{id}/")
  Call<Void> legoPartCategoriesRead(
          @Path("id") String id
  );

  
  /**
   * Get a list of Parts.
   * Get a list of Parts.\n\nOptionally filter by one or more of the below query parameters.
   * @param page null
   * @param pageSize null
   * @param partNum null
   * @param partCatId null
   * @param colorId null
   * @param bricklinkId null
   * @param brickowlId null
   * @param legoId null
   * @param ldrawId null
   * @param ordering null
   * @param search null
   * @return Call<Void>
   */
  
  @GET("api/v3/lego/parts/")
  Call<Void> legoPartsList(
          @Query("page") String page, @Query("page_size") String pageSize, @Query("part_num") String partNum, @Query("part_cat_id") String partCatId, @Query("color_id") String colorId, @Query("bricklink_id") String bricklinkId, @Query("brickowl_id") String brickowlId, @Query("lego_id") String legoId, @Query("ldraw_id") String ldrawId, @Query("ordering") String ordering, @Query("search") String search
  );

  
  /**
   * Get details about a specific Part.
   * Get details about a specific Part.
   * @param partNum null
   * @return Call<Void>
   */
  
  @GET("api/v3/lego/parts/{part_num}/")
  Call<Void> legoPartsRead(
          @Path("part_num") String partNum
  );

  
  /**
   * Get a list of all Colors a Part has appeared in.
   * Get a list of all Colors a Part has appeared in.
   * @param partNum null
   * @param page null
   * @param pageSize null
   * @param ordering null
   * @return Call<Void>
   */
  
  @GET("api/v3/lego/parts/{part_num}/colors/")
  Call<Void> legoPartsColorsList(
          @Path("part_num") String partNum, @Query("page") String page, @Query("page_size") String pageSize, @Query("ordering") String ordering
  );

  
  /**
   * Get details about a specific Part/Color combination.
   * Get details about a specific Part/Color combination.
   * @param colorId null
   * @param partNum null
   * @return Call<Void>
   */
  
  @GET("api/v3/lego/parts/{part_num}/colors/{color_id}/")
  Call<Void> legoPartsColorsRead(
          @Path("color_id") String colorId, @Path("part_num") String partNum
  );

  
  /**
   * Get a list of all Sets the Part/Color combination has appeard in.
   * Get a list of all Sets the Part/Color combination has appeard in.
   * @param colorId null
   * @param partNum null
   * @param page null
   * @param pageSize null
   * @param ordering null
   * @return Call<Void>
   */
  
  @GET("api/v3/lego/parts/{part_num}/colors/{color_id}/sets/")
  Call<Void> legoPartsColorsSetsList(
          @Path("color_id") String colorId, @Path("part_num") String partNum, @Query("page") String page, @Query("page_size") String pageSize, @Query("ordering") String ordering
  );

  
  /**
   * Get a list of Sets, optionally filtered by any of the below parameters.
   * Get a list of Sets, optionally filtered by any of the below parameters.
   * @param page null
   * @param pageSize null
   * @param themeId null
   * @param minYear null
   * @param maxYear null
   * @param minParts null
   * @param maxParts null
   * @param ordering null
   * @param search null
   * @return Call<Void>
   */
  
  @GET("api/v3/lego/sets/")
  Call<Void> legoSetsList(
          @Query("page") String page, @Query("page_size") String pageSize, @Query("theme_id") String themeId, @Query("min_year") String minYear, @Query("max_year") String maxYear, @Query("min_parts") String minParts, @Query("max_parts") String maxParts, @Query("ordering") String ordering, @Query("search") String search
  );

  
  /**
   * Get details for a specific Set.
   * Get details for a specific Set.
   * @param setNum null
   * @return Call<Void>
   */
  
  @GET("api/v3/lego/sets/{set_num}/")
  Call<Void> legoSetsRead(
          @Path("set_num") String setNum
  );

  
  /**
   * Get a list of MOCs which are Alternate Builds of a specific Set - i.e. all parts in the MOC can
   * Get a list of MOCs which are Alternate Builds of a specific Set - i.e. all parts in the MOC can\nbe found in the Set.
   * @param setNum null
   * @param page null
   * @param pageSize null
   * @param ordering null
   * @return Call<Void>
   */
  
  @GET("api/v3/lego/sets/{set_num}/alternates/")
  Call<Void> legoSetsAlternatesList(
          @Path("set_num") String setNum, @Query("page") String page, @Query("page_size") String pageSize, @Query("ordering") String ordering
  );

  
  /**
   * Get a list of all Inventory Parts in this Set.
   * Get a list of all Inventory Parts in this Set.
   * @param setNum null
   * @param page null
   * @param pageSize null
   * @return Call<Void>
   */
  
  @GET("api/v3/lego/sets/{set_num}/parts/")
  Call<Void> legoSetsPartsList(
          @Path("set_num") String setNum, @Query("page") String page, @Query("page_size") String pageSize
  );

  
  /**
   * Get a list of all Inventory Sets in this Set.
   * Get a list of all Inventory Sets in this Set.
   * @param setNum null
   * @param page null
   * @param pageSize null
   * @return Call<Void>
   */
  
  @GET("api/v3/lego/sets/{set_num}/sets/")
  Call<Void> legoSetsSetsList(
          @Path("set_num") String setNum, @Query("page") String page, @Query("page_size") String pageSize
  );

  
  /**
   * Return all Themes
   * Return all Themes
   * @param page null
   * @param pageSize null
   * @param ordering null
   * @return Call<Void>
   */
  
  @GET("api/v3/lego/themes/")
  Call<Void> legoThemesList(
          @Query("page") String page, @Query("page_size") String pageSize, @Query("ordering") String ordering
  );

  
  /**
   * Return details for a specific Theme
   * Return details for a specific Theme
   * @param id null
   * @return Call<Void>
   */
  
  @GET("api/v3/lego/themes/{id}/")
  Call<Void> legoThemesRead(
          @Path("id") String id
  );

  
}
