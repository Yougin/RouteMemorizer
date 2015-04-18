package gmail.ebeletskiy.routememorizer.modules.screens;

import com.google.common.base.Preconditions;
import de.greenrobot.event.EventBus;
import gmail.ebeletskiy.routememorizer.data.PhotosDao;
import gmail.ebeletskiy.routememorizer.data.api.model.Photo;
import gmail.ebeletskiy.routememorizer.events.RefreshPhotosEvent;
import gmail.ebeletskiy.routememorizer.ui.adapters.PhotosAdapter;
import gmail.ebeletskiy.routememorizer.ui.fragments.MainView;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;

public class MainPresenterImpl implements MainPresenter {

  private final MainView view;
  private final EventBus bus;
  private final PhotosDao photosDao;
  private final PhotosAdapter adapter;

  @Inject public MainPresenterImpl(MainView view, EventBus bus, PhotosDao photosDao,
      PhotosAdapter adapter) {
    this.bus = Preconditions.checkNotNull(bus);
    this.view = Preconditions.checkNotNull(view);
    this.photosDao = Preconditions.checkNotNull(photosDao);
    this.adapter = Preconditions.checkNotNull(adapter);
  }

  @Override public void onResume() {
    bus.registerSticky(this);
  }

  @Override public void onPause() {
    bus.unregister(this);
  }

  @Override public void onEventMainThread(RefreshPhotosEvent event) {
    updateAdapter(getListOfPhotos());
  }

  @NotNull private List<Photo> getListOfPhotos() {
    List<Photo> allPhotos = photosDao.getAllPhotos();

    if (allPhotos == null) {
      return Collections.emptyList();
    }

    return allPhotos;
  }

  private void updateAdapter(@NotNull List<Photo> photos) {
    adapter.setData(photos);
    view.setAdapter(adapter);
  }
}
