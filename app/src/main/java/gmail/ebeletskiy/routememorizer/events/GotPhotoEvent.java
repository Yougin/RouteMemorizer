package gmail.ebeletskiy.routememorizer.events;

import org.jetbrains.annotations.NotNull;

public class GotPhotoEvent {

  private String photoUrl;

  public String getPhotoUrl() {
    return photoUrl;
  }

  public void setPhotoUrl(@NotNull String photoUrl) {
    this.photoUrl = photoUrl;
  }
}
