package gmail.ebeletskiy.routememorizer.modules;

import dagger.Module;
import dagger.Provides;
import gmail.ebeletskiy.routememorizer.events.GotPhotoEvent;
import gmail.ebeletskiy.routememorizer.jobs.GetPhotosJob;
import javax.inject.Singleton;

@Module(injects = GetPhotosJob.class, library = true, complete = false)
public class JobsModule {

  @Provides @Singleton GotPhotoEvent provideRefreshPhotosEvent() {
    return new GotPhotoEvent();
  }

}
