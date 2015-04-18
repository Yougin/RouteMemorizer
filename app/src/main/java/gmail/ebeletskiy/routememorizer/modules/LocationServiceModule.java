package gmail.ebeletskiy.routememorizer.modules;

import com.path.android.jobqueue.JobManager;
import dagger.Module;
import dagger.Provides;
import gmail.ebeletskiy.routememorizer.services.ILocationServicePresenter;
import gmail.ebeletskiy.routememorizer.services.ILocationServicePresenterImpl;
import gmail.ebeletskiy.routememorizer.services.LocationService;
import gmail.ebeletskiy.routememorizer.services.LocationUpdateListener;
import javax.inject.Singleton;

@Module(injects = LocationService.class,
    addsTo = ApplicationModule.class)
public class LocationServiceModule {

  @Provides @Singleton ILocationServicePresenter provideLocationServicePresenter(
      ILocationServicePresenterImpl presenter) {
    return presenter;
  }

  @Provides @Singleton LocationUpdateListener provideLocationListener(JobManager jobManager) {
    return new LocationUpdateListener(jobManager);
  }
}
