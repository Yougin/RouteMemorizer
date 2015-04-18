package gmail.ebeletskiy.routememorizer.data;

import gmail.ebeletskiy.routememorizer.data.api.model.Photo;
import io.realm.Realm;
import java.util.List;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

public class RealmPhotosDao implements PhotosDao {

  private final Realm realm;

  @Inject public RealmPhotosDao(Realm realm) {
    this.realm = realm;
  }

  @Override public List<Photo> getAllPhotos() {
    Timber.d(
        "Quering for all photos, the amount of photos in db is " + realm.allObjects(Photo.class)
            .size());

    return realm.allObjects(Photo.class);
  }

  @Override public void savePhoto(@NotNull Photo photo) {
    Timber.d("Saving photo object: " + photo);

    realm.beginTransaction();
    realm.copyToRealm(photo);
    realm.commitTransaction();
  }
}
