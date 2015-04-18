package gmail.ebeletskiy.routememorizer.data;

import gmail.ebeletskiy.routememorizer.data.model.PhotoUrl;
import io.realm.Realm;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

public class RealmPhotosDao implements PhotosDao {

  private final Realm realm;

  @Inject public RealmPhotosDao(Realm realm) {
    this.realm = realm;
  }

  @Override public List<String> getAllPhotos() {
    Timber.d("Querying all photos urls, the amount of photos in db is " + realm.allObjects(
            PhotoUrl.class).size());

    List<String> result = new ArrayList<>();
    for (PhotoUrl photoUrl : realm.allObjects(PhotoUrl.class)) {
      result.add(photoUrl.getUrl());
    }

    return result;
  }

  @Override public void savePhoto(@NotNull String photoUrl) {
    Timber.d("Saving url: " + photoUrl);

    realm.beginTransaction();
    PhotoUrl object = realm.createObject(PhotoUrl.class);
    object.setUrl(photoUrl);
    realm.commitTransaction();
  }
}
