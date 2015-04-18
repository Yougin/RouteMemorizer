package gmail.ebeletskiy.routememorizer.data.api.response;

import com.google.gson.annotations.Expose;
import gmail.ebeletskiy.routememorizer.data.api.model.Photo;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class PhotosResponse {

  @Expose int count;
  @Expose List<Photo> photos = new ArrayList<>();

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  @NotNull public List<Photo> getPhotos() {
    return photos;
  }

  public void setPhotos(List<Photo> photos) {
    this.photos = photos;
  }

  @Override public String toString() {
    return "PhotosResponse{" +
        "count=" + count +
        ", photos=" + photos +
        '}';
  }
}
