package gmail.ebeletskiy.routememorizer.utils.location;

import android.location.Location;
import org.jetbrains.annotations.NotNull;

/**
 * Make sure to set a Location {@link LocationBoundaryHelper#setLocation(android.location.Location)}
 */
public class LocationBoundaryHelper implements ILocationBoundaryProvider {

  public final double DELTA = 0.012;
  public final double FACTOR = 0.2;
  private double multiplier = 1;

  private Location location;

  @Override public void setLocation(@NotNull Location location) {
    this.location = location;
  }

  @Override public void increaseRange() {
    multiplier = multiplier * FACTOR;
  }

  @Override public double getMinX() {
    return location.getLongitude() - DELTA * multiplier;
  }

  @Override public double getMinY() {
    return location.getLatitude() - DELTA * multiplier;
  }

  @Override public double getMaxX() {
    return location.getLongitude() + DELTA * multiplier;
  }

  @Override public double getMaxY() {
    return location.getLatitude() + DELTA * multiplier;
  }
}
