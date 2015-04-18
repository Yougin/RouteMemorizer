package gmail.ebeletskiy.routememorizer.jobs;

import android.content.Context;
import com.path.android.jobqueue.BaseJob;
import com.path.android.jobqueue.di.DependencyInjector;
import gmail.ebeletskiy.routememorizer.App;

public class JobDependencyInjector implements DependencyInjector {
  private Context context;

  public JobDependencyInjector(Context context) {
    this.context = context;
  }

  @Override public void inject(BaseJob job) {
    ((App) context).getObjectGraph().inject(job);
  }
}
