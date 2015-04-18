package gmail.ebeletskiy.routememorizer;

import android.app.Application;
import dagger.ObjectGraph;
import gmail.ebeletskiy.routememorizer.modules.ApplicationModule;
import gmail.ebeletskiy.routememorizer.utils.logging.ReleaseReportingTree;
import java.util.Arrays;
import java.util.List;
import timber.log.Timber;

public class App extends Application {

  private ObjectGraph objectGraph;

  @Override public void onCreate() {
    super.onCreate();

    objectGraph = ObjectGraph.create(getModules().toArray());
    objectGraph.inject(this);

    setupTimberPlant();
  }

  public ObjectGraph createScopedGraph(Object... modules) {
    return objectGraph.plus(modules);
  }

  public ObjectGraph getObjectGraph() {
    return objectGraph;
  }

  public List<Object> getModules() {
    return Arrays.<Object>asList(new ApplicationModule(this));
  }

  private void setupTimberPlant() {
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    } else {
      Timber.plant(new ReleaseReportingTree());
    }
  }
}
