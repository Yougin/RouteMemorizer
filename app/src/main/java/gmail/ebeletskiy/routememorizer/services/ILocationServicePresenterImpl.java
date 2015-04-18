package gmail.ebeletskiy.routememorizer.services;

import com.google.android.gms.location.LocationListener;
import de.greenrobot.event.EventBus;
import gmail.ebeletskiy.routememorizer.data.prefs.IServiceWatcher;
import gmail.ebeletskiy.routememorizer.events.ApiClientConnectedEvent;
import gmail.ebeletskiy.routememorizer.utils.helpers.Preconditions;
import gmail.ebeletskiy.routememorizer.utils.location.ILocationProvider;
import javax.inject.Inject;

public class ILocationServicePresenterImpl implements ILocationServicePresenter {

  private final ILocationProvider locationProvider;
  private final LocationListener locationUpdateListener;
  private final IServiceWatcher serviceWatcher;
  private final EventBus bus;

  @Inject public ILocationServicePresenterImpl(ILocationProvider locationProvider,
      LocationUpdateListener locationUpdateListener, EventBus bus, IServiceWatcher serviceWatcher) {
    this.locationProvider = Preconditions.checkNotNull(locationProvider);
    this.locationUpdateListener = Preconditions.checkNotNull(locationUpdateListener);
    this.bus = Preconditions.checkNotNull(bus);
    this.serviceWatcher = Preconditions.checkNotNull(serviceWatcher);
  }

  @Override public void start() {
    bus.register(this);
    locationProvider.connect();
    serviceWatcher.setServiceRunning(true);
  }

  @Override public void stop() {
    bus.unregister(this);
    locationProvider.disconnect();
    serviceWatcher.setServiceRunning(false);
  }

  @Override public void onEvent(ApiClientConnectedEvent event) {
    locationProvider.setLocationUpdateListener(locationUpdateListener);
    locationProvider.startLocationUpdates();
  }
}
