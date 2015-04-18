package gmail.ebeletskiy.routememorizer.data.model;

import io.realm.RealmObject;

public class PhotoUrl extends RealmObject {

  private String url;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
