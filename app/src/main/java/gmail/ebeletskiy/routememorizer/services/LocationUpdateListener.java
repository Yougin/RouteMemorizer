package gmail.ebeletskiy.routememorizer.services;

import android.location.Location;
import com.google.android.gms.location.LocationListener;
import com.path.android.jobqueue.JobManager;
import gmail.ebeletskiy.routememorizer.jobs.GetPhotosJob;
import javax.inject.Inject;

public class LocationUpdateListener implements LocationListener {

  @Inject JobManager jobManager;

  @Override public void onLocationChanged(Location location) {
    jobManager.addJob(new GetPhotosJob(location));
  }
}
