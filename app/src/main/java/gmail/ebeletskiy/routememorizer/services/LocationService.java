package gmail.ebeletskiy.routememorizer.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import dagger.ObjectGraph;
import gmail.ebeletskiy.routememorizer.App;
import gmail.ebeletskiy.routememorizer.modules.LocationServiceModule;
import javax.inject.Inject;
import timber.log.Timber;

public class LocationService extends Service {

  protected ObjectGraph scopedGraph;
  @Inject ILocationServicePresenter presenter;

  @Override public void onCreate() {
    Timber.d("Creating a Location Service...");
    scopedGraph = ((App) getApplication()).createScopedGraph(new LocationServiceModule());
    scopedGraph.inject(this);
  }

  @Override public int onStartCommand(Intent intent, int flags, int startId) {
    Timber.d("Starting the Service...");

    presenter.start();

    return START_STICKY;
  }

  @Override public void onDestroy() {
    Timber.d("Stopping the Service...");
    super.onDestroy();

    presenter.stop();
    scopedGraph = null;
  }

  @Override public IBinder onBind(Intent intent) {
    // no binding
    return null;
  }

}
