package gmail.ebeletskiy.routememorizer.modules;

import android.view.LayoutInflater;
import com.path.android.jobqueue.JobManager;
import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import gmail.ebeletskiy.routememorizer.App;
import gmail.ebeletskiy.routememorizer.jobs.JobManagerFactory;
import javax.inject.Singleton;

@Module(injects = App.class,
    library = true)
public class ApplicationModule {

  private App app;

  public ApplicationModule(App app) {
    this.app = app;
  }

  @Provides @Singleton App provideApplicationContext() {
    return app;
  }

  @Provides @Singleton EventBus provideEventBus() {
    return EventBus.builder().throwSubscriberException(true).build();
  }

  @Provides @Singleton JobManager provideJobManager(App context) {
    return JobManagerFactory.getConfiguredJobManager(context);
  }

  @Provides @Singleton LayoutInflater provideLayoutInflater(App app) {
    return LayoutInflater.from(app);
  }
}
