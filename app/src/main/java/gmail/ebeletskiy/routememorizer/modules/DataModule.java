package gmail.ebeletskiy.routememorizer.modules;

import android.content.SharedPreferences;
import android.net.Uri;
import com.squareup.picasso.Picasso;
import dagger.Module;
import dagger.Provides;
import gmail.ebeletskiy.routememorizer.App;
import gmail.ebeletskiy.routememorizer.data.persistance.PhotosDao;
import gmail.ebeletskiy.routememorizer.data.persistance.RealmPhotosDao;
import gmail.ebeletskiy.routememorizer.data.prefs.IServiceWatcher;
import gmail.ebeletskiy.routememorizer.data.prefs.ServiceWatcherImpl;
import io.realm.Realm;
import javax.inject.Singleton;
import timber.log.Timber;

import static android.content.Context.MODE_PRIVATE;

@Module(library = true, complete = false)
public class DataModule {

  @Provides @Singleton PhotosDao providePhotoUrlsDao(RealmPhotosDao dao) {
    return dao;
  }

  @Provides @Singleton Realm provideRealm(App app) {
    return Realm.getInstance(app);
  }

  @Provides @Singleton IServiceWatcher provideServiceWatcher(ServiceWatcherImpl serviceWatcher) {
    return serviceWatcher;
  }

  @Provides @Singleton SharedPreferences provideSharedPreferences(App app) {
    return app.getSharedPreferences("gmail.ebeletskiy.routememorizer", MODE_PRIVATE);
  }

  @Provides @Singleton Picasso providePicasso(App app) {
    return new Picasso.Builder(app).listener(new Picasso.Listener() {
      @Override public void onImageLoadFailed(Picasso picasso, Uri uri, Exception e) {
        Timber.e(e, "Failed to load image: %s", uri);
      }
    }).build();
  }
}
