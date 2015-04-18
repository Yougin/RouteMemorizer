package gmail.ebeletskiy.routememorizer.data.api;

import java.util.List;
import retrofit.http.GET;
import retrofit.http.Query;

public interface WebService {
  /**
   * The Endpoint to fetch a list of images within specified boundaries
   *
   * @return a list of Photos {@link gmail.ebeletskiy.routememorizer.data.api.model.Photo}
   */
  @GET("/map/get_panoramas.php?set=public&from=0&to=20&size=medium&mapfilter=true")
  List<String> getImages(
      @Query("minx") double minx,
      @Query("miny") double miny,
      @Query("maxx") double maxx,
      @Query("maxy") double maxy);
}
