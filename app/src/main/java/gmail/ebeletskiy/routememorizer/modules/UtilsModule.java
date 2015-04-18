package gmail.ebeletskiy.routememorizer.modules;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import gmail.ebeletskiy.routememorizer.App;
import gmail.ebeletskiy.routememorizer.events.ApiClientConnectedEvent;
import gmail.ebeletskiy.routememorizer.events.LocationUpdateEvent;
import gmail.ebeletskiy.routememorizer.utils.location.ILocationBoundaryProvider;
import gmail.ebeletskiy.routememorizer.utils.location.ILocationProvider;
import gmail.ebeletskiy.routememorizer.utils.location.LocationBoundaryHelper;
import gmail.ebeletskiy.routememorizer.utils.location.UserLocationProvider;
import javax.inject.Singleton;

@Module(library = true, complete = false)
public class UtilsModule {

  public static final int SMALLEST_DISPLACEMENT_METERS = 100;
  public static final int UPDATE_INTERVAL = 5 * 1000;
  public static final int FASTEST_INTERVAL = 2 * 1000;

  @Provides @Singleton GoogleApiClient.Builder provideGoogleApiClientBuilder(App app) {
    return new GoogleApiClient.Builder(app);
  }

  @Provides @Singleton ILocationProvider provideUserLocationProvider(GoogleApiClient.Builder client,
      EventBus bus, LocationUpdateEvent locationUpdateEvent,
      ApiClientConnectedEvent apiClientConnectedEvent, LocationRequest locationRequest) {
    return new UserLocationProvider(client, bus, apiClientConnectedEvent, locationRequest);
  }

  @Provides @Singleton ApiClientConnectedEvent provideApiClientConnectedEvent() {
    return new ApiClientConnectedEvent();
  }

  @Provides @Singleton LocationUpdateEvent provideLocationUpdateEvent() {
    return new LocationUpdateEvent();
  }

  @Provides @Singleton LocationRequest provideLocationRequest() {
    LocationRequest locationRequest = LocationRequest.create();
    locationRequest.setInterval(UPDATE_INTERVAL);
    locationRequest.setFastestInterval(FASTEST_INTERVAL);
    locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    locationRequest.setSmallestDisplacement(SMALLEST_DISPLACEMENT_METERS);
    return locationRequest;
  }

  @Provides ILocationBoundaryProvider provideLocationBoundaryProvider() {
    return new LocationBoundaryHelper();
  }
}
