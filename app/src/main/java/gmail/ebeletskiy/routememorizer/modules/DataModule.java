package gmail.ebeletskiy.routememorizer.modules;

import dagger.Module;
import dagger.Provides;
import gmail.ebeletskiy.routememorizer.App;
import gmail.ebeletskiy.routememorizer.data.PhotoUrlsDao;
import gmail.ebeletskiy.routememorizer.data.RealmPhotoUrlsDao;
import io.realm.Realm;
import javax.inject.Singleton;

@Module(library = true, complete = false)
public class DataModule {

  @Singleton @Provides PhotoUrlsDao providePhotoUrlsDao() {
    return new RealmPhotoUrlsDao();
  }

  @Singleton @Provides Realm provideRealm(App app) {
    return Realm.getInstance(app);
  }

}
