package gmail.ebeletskiy.routememorizer.jobs;

import android.location.Location;
import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

public class GetPhotosJob extends BaseJob {

  public GetPhotosJob(Location location) {
    super(new Params(Priority.NORMAL));


  }

  @Override public void onAdded() {

  }

  @Override public void onRun() throws Throwable {

  }

  @Override protected void onCancel() {

  }

  @Override protected boolean shouldReRunOnThrowable(Throwable throwable) {
    return false;
  }
}
