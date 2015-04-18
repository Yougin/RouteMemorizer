package gmail.ebeletskiy.routememorizer.data.prefs;

import android.content.SharedPreferences;
import gmail.ebeletskiy.routememorizer.utils.helpers.Preconditions;
import javax.inject.Inject;

public class ServiceWatcherImpl implements IServiceWatcher {

  public static final String IS_SERVICE_RUNNING = "is_service_running";
  private final SharedPreferences prefs;

  @Inject public ServiceWatcherImpl(SharedPreferences prefs) {
    this.prefs = Preconditions.checkNotNull(prefs);
  }

  @Override public boolean isServiceRunning() {
    return prefs.getBoolean(IS_SERVICE_RUNNING, false);
  }

  @Override public void setServiceRunning(boolean isServiceRunning) {
    prefs.edit().putBoolean(IS_SERVICE_RUNNING, isServiceRunning).apply();
  }
}
