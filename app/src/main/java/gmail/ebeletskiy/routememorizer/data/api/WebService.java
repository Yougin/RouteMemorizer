package gmail.ebeletskiy.routememorizer.data.api;

import gmail.ebeletskiy.routememorizer.data.api.response.PhotosResponse;
import retrofit.http.GET;
import retrofit.http.Query;

public interface WebService {
  /**
   * The Endpoint to fetch a list of images within specified boundaries
   *
   * @return a list of Photos {@link gmail.ebeletskiy.routememorizer.data.api.model.Photo}
   */
  @GET("/map/get_panoramas.php?set=public&from=0&to=2&size=medium&mapfilter=true")
  PhotosResponse getImages(
      @Query("minx") double minx,
      @Query("miny") double miny,
      @Query("maxx") double maxx,
      @Query("maxy") double maxy);
}
