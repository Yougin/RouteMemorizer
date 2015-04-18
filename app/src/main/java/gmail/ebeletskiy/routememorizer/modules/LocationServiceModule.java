package gmail.ebeletskiy.routememorizer.modules;

import dagger.Module;
import dagger.Provides;
import gmail.ebeletskiy.routememorizer.services.ILocationServicePresenter;
import gmail.ebeletskiy.routememorizer.services.ILocationServicePresenterImpl;
import gmail.ebeletskiy.routememorizer.services.LocationService;
import javax.inject.Singleton;

@Module(injects = LocationService.class,
    addsTo = ApplicationModule.class)
public class LocationServiceModule {

  @Provides @Singleton ILocationServicePresenter provideLocationServicePresenter() {
    return new ILocationServicePresenterImpl();
  }

}
