package gmail.ebeletskiy.routememorizer.modules;

import com.google.android.gms.common.api.GoogleApiClient;
import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import gmail.ebeletskiy.routememorizer.App;
import gmail.ebeletskiy.routememorizer.events.ApiClientConnectedEvent;
import gmail.ebeletskiy.routememorizer.events.LocationUpdateEvent;
import gmail.ebeletskiy.routememorizer.utils.location.ILocationProvider;
import gmail.ebeletskiy.routememorizer.utils.location.UserLocationProvider;
import javax.inject.Singleton;

@Module(library = true, complete = false)
public class UtilsModule {

  @Provides @Singleton GoogleApiClient.Builder provideGoogleApiClientBuilder(App app) {
    return new GoogleApiClient.Builder(app);
  }

  @Provides @Singleton ILocationProvider provideUserLocationProvider(GoogleApiClient.Builder client,
      EventBus bus, LocationUpdateEvent locationUpdateEvent,
      ApiClientConnectedEvent apiClientConnectedEvent) {
    return new UserLocationProvider(client, bus, apiClientConnectedEvent);
  }

  @Provides @Singleton ApiClientConnectedEvent provideApiClientConnectedEvent() {
    return new ApiClientConnectedEvent();
  }

  @Provides @Singleton LocationUpdateEvent provideLocationUpdateEvent() {
    return new LocationUpdateEvent();
  }
}
