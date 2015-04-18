package gmail.ebeletskiy.routememorizer.data;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface PhotosDao {

  List<String> getAllPhotos();

  void savePhoto(@NotNull String photo);
}
