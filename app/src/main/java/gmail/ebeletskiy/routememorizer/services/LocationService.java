package gmail.ebeletskiy.routememorizer.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import dagger.ObjectGraph;
import gmail.ebeletskiy.routememorizer.App;
import gmail.ebeletskiy.routememorizer.modules.LocationServiceModule;
import javax.inject.Inject;

public class LocationService extends Service {

  protected ObjectGraph scopedGraph;
  @Inject ILocationServicePresenter presenter;

  @Override public void onCreate() {
    scopedGraph = ((App) getApplication()).createScopedGraph(new LocationServiceModule());
    scopedGraph.inject(this);
  }

  @Override public int onStartCommand(Intent intent, int flags, int startId) {
    presenter.start();

    return START_STICKY;
  }

  @Override public void onDestroy() {
    super.onDestroy();

    scopedGraph = null;
  }

  @Override public IBinder onBind(Intent intent) {
    // no binding
    return null;
  }

}
