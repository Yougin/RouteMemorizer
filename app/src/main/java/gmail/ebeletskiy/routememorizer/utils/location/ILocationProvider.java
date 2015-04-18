package gmail.ebeletskiy.routememorizer.utils.location;

import android.location.Location;
import com.google.android.gms.location.LocationListener;
import org.jetbrains.annotations.Nullable;

public interface ILocationProvider {

  void connect();

  void disconnect();

  @Nullable Location getLastKnownUserLocation();

  void setLocationUpdateListener(LocationListener locationUpdateListener);

  void startLocationUpdates();
}
