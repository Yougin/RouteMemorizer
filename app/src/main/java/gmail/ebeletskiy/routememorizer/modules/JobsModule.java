package gmail.ebeletskiy.routememorizer.modules;

import dagger.Module;
import dagger.Provides;
import gmail.ebeletskiy.routememorizer.events.RefreshPhotosEvent;
import gmail.ebeletskiy.routememorizer.jobs.GetPhotosJob;
import javax.inject.Singleton;

@Module(injects = GetPhotosJob.class, library = true, complete = false)
public class JobsModule {

  @Provides @Singleton RefreshPhotosEvent provideRefreshPhotosEvent() {
    return new RefreshPhotosEvent();
  }

}
