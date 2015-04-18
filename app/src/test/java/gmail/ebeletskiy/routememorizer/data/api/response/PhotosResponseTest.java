package gmail.ebeletskiy.routememorizer.data.api.response;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class PhotosResponseTest {

  public static final String PHOTO_FILE_URL =
      "http://mw2.google.com/mw-panoramio/photos/medium/80402571.jpg";
  public static final int AMOUNT_OF_PHOTOS = 10;

  private Gson gson;

  @Before public void setUp() throws Exception {
    gson = new Gson();
  }

  @Test public void should_parse_proper_json_into_pojo() throws Exception {
    PhotosResponse photosResponse = gson.fromJson(properJson, PhotosResponse.class);

    assertThat(photosResponse, is(notNullValue()));
  }

  @Test public void should_response_contain_expected_amount_of_photo_objects() throws Exception {
    PhotosResponse photosResponse = gson.fromJson(properJson, PhotosResponse.class);

    assertThat(photosResponse.getPhotos(), is(notNullValue()));
    assertThat(photosResponse.getPhotos().size(), is(equalTo(AMOUNT_OF_PHOTOS)));
  }

  @Test public void should_photo_object_contain_image_url() throws Exception {
    PhotosResponse photosResponse = gson.fromJson(properJson, PhotosResponse.class);

    assertThat(photosResponse.getPhotos().get(0), is(notNullValue()));
    assertThat(photosResponse.getPhotos().get(0).getPhotoFileUrl(), is(PHOTO_FILE_URL));
  }

  String properJson =
      "{\"count\":154,\"has_more\":false,\"map_location\":{\"lat\":52.516802999999996,\"lon\":13.277839099999946,\"panoramio_zoom\":0},\"photos\":[{\"height\":500,\"latitude\":52.519593,\"longitude\":13.277376,\"owner_id\":2034101,\"owner_name\":\"JO Cervantes D\",\"owner_url\":\"http://www.panoramio.com/user/2034101\",\"photo_file_url\":\""
          + PHOTO_FILE_URL
          + "\",\"photo_id\":80402571,\"photo_title\":\"E.T. in Berlin\",\"photo_url\":\"http://www.panoramio.com/photo/80402571\",\"upload_date\":\"11 October 2012\",\"width\":319},{\"height\":333,\"latitude\":52.518707999999997,\"longitude\":13.277068999999999,\"owner_id\":7021275,\"owner_name\":\"Blendenteufel\",\"owner_url\":\"http://www.panoramio.com/user/7021275\",\"photo_file_url\":\"http://mw2.google.com/mw-panoramio/photos/medium/74880006.jpg\",\"photo_id\":74880006,\"photo_title\":\"Eingang\",\"photo_url\":\"http://www.panoramio.com/photo/74880006\",\"upload_date\":\"05 July 2012\",\"width\":500},{\"height\":375,\"latitude\":52.518515999999998,\"longitude\":13.279802,\"owner_id\":989264,\"owner_name\":\"schmidt@was-aufs-ohr.de\",\"owner_url\":\"http://www.panoramio.com/user/989264\",\"photo_file_url\":\"http://mw2.google.com/mw-panoramio/photos/medium/5212779.jpg\",\"photo_id\":5212779,\"photo_title\":\"F\\u00fcrstenbrunner Weg / Spandauer Damm\",\"photo_url\":\"http://www.panoramio.com/photo/5212779\",\"upload_date\":\"10 October 2007\",\"width\":500},{\"height\":74,\"latitude\":52.513624999999998,\"longitude\":13.277061,\"owner_id\":2901204,\"owner_name\":\"Klaus, Berlin\",\"owner_url\":\"http://www.panoramio.com/user/2901204\",\"photo_file_url\":\"http://mw2.google.com/mw-panoramio/photos/medium/32606564.jpg\",\"photo_id\":32606564,\"photo_title\":\"Soorstra\\u00dfe bei Nacht, Berlin\",\"photo_url\":\"http://www.panoramio.com/photo/32606564\",\"upload_date\":\"25 February 2010\",\"width\":500},{\"height\":333,\"latitude\":52.514139999999998,\"longitude\":13.27778,\"owner_id\":5532188,\"owner_name\":\"\\u00c4tschi-b\\u00e4tschi\",\"owner_url\":\"http://www.panoramio.com/user/5532188\",\"photo_file_url\":\"http://mw2.google.com/mw-panoramio/photos/medium/47788388.jpg\",\"photo_id\":47788388,\"photo_title\":\"Soorstra\\u00dfe 79\",\"photo_url\":\"http://www.panoramio.com/photo/47788388\",\"upload_date\":\"08 February 2011\",\"width\":500},{\"height\":500,\"latitude\":52.514788000000003,\"longitude\":13.279552000000001,\"owner_id\":805568,\"owner_name\":\"KarinvanVliet\",\"owner_url\":\"http://www.panoramio.com/user/805568\",\"photo_file_url\":\"http://mw2.google.com/mw-panoramio/photos/medium/54937380.jpg\",\"photo_id\":54937380,\"photo_title\":\"Hotel Arizona\",\"photo_url\":\"http://www.panoramio.com/photo/54937380\",\"upload_date\":\"29 June 2011\",\"width\":500},{\"height\":375,\"latitude\":52.519981000000001,\"longitude\":13.277561,\"owner_id\":1992523,\"owner_name\":\"Corbett Santana\",\"owner_url\":\"http://www.panoramio.com/user/1992523\",\"photo_file_url\":\"http://mw2.google.com/mw-panoramio/photos/medium/105327649.jpg\",\"photo_id\":105327649,\"photo_title\":\"DRK Kliniken Berlin Westend\",\"photo_url\":\"http://www.panoramio.com/photo/105327649\",\"upload_date\":\"06 April 2014\",\"width\":500},{\"height\":500,\"latitude\":52.519191999999997,\"longitude\":13.277092,\"owner_id\":1992523,\"owner_name\":\"Corbett Santana\",\"owner_url\":\"http://www.panoramio.com/user/1992523\",\"photo_file_url\":\"http://mw2.google.com/mw-panoramio/photos/medium/105328309.jpg\",\"photo_id\":105328309,\"photo_title\":\"DRK Kliniken Berlin Westend\",\"photo_url\":\"http://www.panoramio.com/photo/105328309\",\"upload_date\":\"06 April 2014\",\"width\":375},{\"height\":375,\"latitude\":52.518366,\"longitude\":13.277556000000001,\"owner_id\":53153,\"owner_name\":\"Klaus Danehl\",\"owner_url\":\"http://www.panoramio.com/user/53153\",\"photo_file_url\":\"http://mw2.google.com/mw-panoramio/photos/medium/73625356.jpg\",\"photo_id\":73625356,\"photo_title\":\"Klinikum Westend\",\"photo_url\":\"http://www.panoramio.com/photo/73625356\",\"upload_date\":\"12 June 2012\",\"width\":500},{\"height\":375,\"latitude\":52.519824999999997,\"longitude\":13.277542,\"owner_id\":1992523,\"owner_name\":\"Corbett Santana\",\"owner_url\":\"http://www.panoramio.com/user/1992523\",\"photo_file_url\":\"http://mw2.google.com/mw-panoramio/photos/medium/105328080.jpg\",\"photo_id\":105328080,\"photo_title\":\"DRK Kliniken Berlin Westend\",\"photo_url\":\"http://www.panoramio.com/photo/105328080\",\"upload_date\":\"06 April 2014\",\"width\":500}]}";
}