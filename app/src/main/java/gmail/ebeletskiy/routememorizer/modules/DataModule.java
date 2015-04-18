package gmail.ebeletskiy.routememorizer.modules;

import android.net.Uri;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;
import dagger.Module;
import dagger.Provides;
import gmail.ebeletskiy.routememorizer.App;
import gmail.ebeletskiy.routememorizer.data.PhotosDao;
import gmail.ebeletskiy.routememorizer.data.RealmPhotosDao;
import io.realm.Realm;
import javax.inject.Singleton;
import timber.log.Timber;

@Module(library = true, complete = false)
public class DataModule {

  @Provides @Singleton PhotosDao providePhotoUrlsDao(RealmPhotosDao dao) {
    return dao;
  }

  @Provides @Singleton Realm provideRealm(App app) {
    return Realm.getInstance(app);
  }

  @Provides @Singleton Picasso providePicasso(App app) {
    return new Picasso.Builder(app)
        .listener(new Picasso.Listener() {
          @Override public void onImageLoadFailed(Picasso picasso, Uri uri, Exception e) {
            Timber.e(e, "Failed to load image: %s", uri);
          }
        })
        .build();
  }
}
