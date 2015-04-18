package gmail.ebeletskiy.routememorizer.modules;

import dagger.Module;
import dagger.Provides;
import gmail.ebeletskiy.routememorizer.data.PhotoUrlsDao;
import gmail.ebeletskiy.routememorizer.data.RealmPhotoUrlsDao;
import javax.inject.Singleton;

@Module(library = true, complete = false)
public class DataModule {

  @Singleton @Provides PhotoUrlsDao providePhotoUrlsDao() {
    return new RealmPhotoUrlsDao();
  }

}
