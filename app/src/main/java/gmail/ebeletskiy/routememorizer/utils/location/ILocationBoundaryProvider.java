package gmail.ebeletskiy.routememorizer.utils.location;

import android.location.Location;
import org.jetbrains.annotations.NotNull;

public interface ILocationBoundaryProvider {

  void setLocation(@NotNull Location location);

  void increaseRange();

  double getMinX();

  double getMinY();

  double getMaxX();

  double getMaxY();
}
