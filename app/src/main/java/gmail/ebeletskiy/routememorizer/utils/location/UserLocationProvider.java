package gmail.ebeletskiy.routememorizer.utils.location;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import de.greenrobot.event.EventBus;
import gmail.ebeletskiy.routememorizer.events.ApiClientConnectedEvent;
import gmail.ebeletskiy.routememorizer.utils.helpers.Preconditions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;

public class UserLocationProvider
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
    ILocationProvider {

  private final GoogleApiClient.Builder builder;
  private final EventBus bus;
  private final ApiClientConnectedEvent apiClientConnectedEvent;
  private final LocationRequest locationRequest;

  private GoogleApiClient mApiClient;
  private Location lastKnownUserLocation;
  private LocationListener locationUpdateListener;

  public UserLocationProvider(@NotNull GoogleApiClient.Builder builder, @NotNull EventBus bus,
      @NotNull ApiClientConnectedEvent apiClientConnectedEvent, @NotNull LocationRequest locationRequest) {
    this.builder = Preconditions.checkNotNull(builder);
    this.bus = Preconditions.checkNotNull(bus);
    this.apiClientConnectedEvent = Preconditions.checkNotNull(apiClientConnectedEvent);
    this.locationRequest = Preconditions.checkNotNull(locationRequest);
  }

  public void connect() {
    Timber.d("Connecting to location services...");

    if (isConnectedOrConnecting()) {
      Timber.e("Looks like we connected already");
      return;
    }

    createClientIfRequired();
    mApiClient.connect();
  }

  private void createClientIfRequired() {
    if (mApiClient == null) {
      mApiClient = builder.addConnectionCallbacks(this)
          .addOnConnectionFailedListener(this)
          .addApi(LocationServices.API)
          .build();
    }
  }

  public void disconnect() {
    if (isConnectedOrConnecting()) {
      mApiClient.disconnect();
    }
  }

  @Override public void setLocationUpdateListener(
      @NotNull LocationListener locationUpdateListener) {
    this.locationUpdateListener = locationUpdateListener;
  }

  @Override public void startLocationUpdates() {
    Preconditions.checkNotNull(locationUpdateListener,
        "You must set locationUpdateListener before invoking this method");

    LocationServices.FusedLocationApi
        .requestLocationUpdates(mApiClient, locationRequest, locationUpdateListener);
  }

  @Override public void onConnected(Bundle bundle) {
    Timber.d("onConnected");

    Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(mApiClient);
    if (lastLocation != null) {
      Timber.d(
          "Location fetched " + lastLocation.getLatitude() + " " + lastLocation.getLongitude());
      lastKnownUserLocation = lastLocation;
      bus.postSticky(apiClientConnectedEvent);
    } else {
      Timber.d("last location is null");
    }
  }

  @Override public void onConnectionSuspended(int i) {
    Timber.d("onConnectionSuspended - to be implemented next release");
  }

  @Override public void onConnectionFailed(ConnectionResult connectionResult) {
    Timber.d("onConnectionFailed - to be implemented next release");
  }

  private boolean isConnectedOrConnecting() {
    return mApiClient != null && (mApiClient.isConnected() || mApiClient.isConnecting());
  }
}
