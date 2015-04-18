package gmail.ebeletskiy.routememorizer.data;

import gmail.ebeletskiy.routememorizer.data.api.model.Photo;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface PhotoUrlsDao {

  List<Photo> getAllPhotos();

  void savePhoto(@NotNull Photo photoUrl);
}
