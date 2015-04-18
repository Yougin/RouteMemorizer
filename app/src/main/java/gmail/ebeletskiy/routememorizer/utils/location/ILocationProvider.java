package gmail.ebeletskiy.routememorizer.utils.location;

import com.google.android.gms.location.LocationListener;
import org.jetbrains.annotations.NotNull;

public interface ILocationProvider {

  void connect();

  void disconnect();

  void setLocationUpdateListener(@NotNull LocationListener locationUpdateListener);

  void startLocationUpdates();
}
