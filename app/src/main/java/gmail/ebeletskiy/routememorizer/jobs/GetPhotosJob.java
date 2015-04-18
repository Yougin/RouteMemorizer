package gmail.ebeletskiy.routememorizer.jobs;

import android.location.Location;
import com.path.android.jobqueue.Params;
import de.greenrobot.event.EventBus;
import gmail.ebeletskiy.routememorizer.data.PhotosDao;
import gmail.ebeletskiy.routememorizer.data.api.WebService;
import gmail.ebeletskiy.routememorizer.data.api.model.Photo;
import gmail.ebeletskiy.routememorizer.data.api.response.PhotosResponse;
import gmail.ebeletskiy.routememorizer.events.NoPhotoAvailableEvent;
import gmail.ebeletskiy.routememorizer.events.RefreshPhotosEvent;
import gmail.ebeletskiy.routememorizer.utils.location.LocationBoundaryHelper;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;

public class GetPhotosJob extends BaseJob {

  private static final int FIRST_IMAGE = 0;

  @NotNull private final Location location;

  @Inject WebService webService;
  @Inject EventBus bus;
  @Inject LocationBoundaryHelper locationBoundaryHelper;
  @Inject RefreshPhotosEvent refreshPhotosEvent;
  @Inject PhotosDao photosDao;

  public GetPhotosJob(@NotNull Location location) {
    super(new Params(Priority.NORMAL).requireNetwork().persist());
    this.location = location;
  }

  @Override public void onAdded() {
    // do nothing
  }

  @Override public void onRun() throws Throwable {
    locationBoundaryHelper.setLocation(location);

    double minX = locationBoundaryHelper.getMinX();
    double minY = locationBoundaryHelper.getMinY();
    double maxX = locationBoundaryHelper.getMaxX();
    double maxY = locationBoundaryHelper.getMaxY();

    PhotosResponse photosResponse = webService.getImages(minX, minY, maxX, maxY);

    Photo photo = photosResponse.getPhotos().get(FIRST_IMAGE);

    if (photo != null) {
      persistPhoto(photo);
      bus.postSticky(refreshPhotosEvent);
    } else {
      bus.postSticky(new NoPhotoAvailableEvent()); // TODO: Handle event
    }
  }

  private void persistPhoto(Photo photoUrl) {
    photosDao.savePhoto(photoUrl);
  }

  @Override protected void onCancel() {
    // do nothing
  }

  @Override protected boolean shouldReRunOnThrowable(Throwable throwable) {
    return true;
  }
}
