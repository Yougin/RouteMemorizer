package gmail.ebeletskiy.routememorizer.services;

import android.location.Location;
import com.google.android.gms.location.LocationListener;
import com.path.android.jobqueue.JobManager;
import gmail.ebeletskiy.routememorizer.jobs.GetPhotosJob;
import gmail.ebeletskiy.routememorizer.utils.helpers.Preconditions;
import javax.inject.Inject;
import timber.log.Timber;

public class LocationUpdateListener implements LocationListener {

  private final JobManager jobManager;

  @Inject public LocationUpdateListener(JobManager jobManager) {
    this.jobManager = Preconditions.checkNotNull(jobManager);
  }

  @Override public void onLocationChanged(Location location) {
    Timber.e("Location update received " + location);

    jobManager.addJob(new GetPhotosJob(location));
  }
}
