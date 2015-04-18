package gmail.ebeletskiy.routememorizer.services;

import com.google.android.gms.location.LocationListener;
import gmail.ebeletskiy.routememorizer.events.ApiClientConnectedEvent;
import gmail.ebeletskiy.routememorizer.utils.helpers.Preconditions;
import gmail.ebeletskiy.routememorizer.utils.location.ILocationProvider;
import javax.inject.Inject;

public class ILocationServicePresenterImpl implements ILocationServicePresenter {

  private final ILocationProvider locationProvider;
  private final LocationListener locationUpdateListener;

  @Inject public ILocationServicePresenterImpl(ILocationProvider locationProvider,
      LocationListener locationUpdateListener) {
    this.locationProvider = Preconditions.checkNotNull(locationProvider);
    this.locationUpdateListener = Preconditions.checkNotNull(locationUpdateListener);
  }

  @Override public void start() {
    locationProvider.connect();
  }

  @Override public void onEvent(ApiClientConnectedEvent event) {
    locationProvider.setLocationUpdateListener(locationUpdateListener);
    locationProvider.startLocationUpdates();
  }
}
