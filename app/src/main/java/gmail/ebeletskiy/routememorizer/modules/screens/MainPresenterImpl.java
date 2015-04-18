package gmail.ebeletskiy.routememorizer.modules.screens;

import de.greenrobot.event.EventBus;
import gmail.ebeletskiy.routememorizer.data.persistance.PhotosDao;
import gmail.ebeletskiy.routememorizer.data.prefs.IServiceWatcher;
import gmail.ebeletskiy.routememorizer.events.GotPhotoEvent;
import gmail.ebeletskiy.routememorizer.events.NoPhotoAvailableEvent;
import gmail.ebeletskiy.routememorizer.ui.adapters.PhotosAdapter;
import gmail.ebeletskiy.routememorizer.ui.fragments.MainView;
import gmail.ebeletskiy.routememorizer.utils.helpers.Preconditions;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;

// TODO: inject resources and extract string from there
public class MainPresenterImpl implements MainPresenter {

  private final MainView view;
  private final EventBus bus;
  private final PhotosDao photosDao;
  private final PhotosAdapter adapter;
  private final IServiceWatcher serviceWatcher;

  @Inject public MainPresenterImpl(MainView view, EventBus bus, PhotosDao photosDao,
      PhotosAdapter adapter, IServiceWatcher serviceWatcher) {
    this.bus = Preconditions.checkNotNull(bus);
    this.view = Preconditions.checkNotNull(view);
    this.photosDao = Preconditions.checkNotNull(photosDao);
    this.adapter = Preconditions.checkNotNull(adapter);
    this.serviceWatcher = Preconditions.checkNotNull(serviceWatcher);
  }

  @Override public void onResume() {
    bus.registerSticky(this);
    updateUi();
  }

  @Override public void onPause() {
    bus.unregister(this);
  }

  @Override public void onEventMainThread(GotPhotoEvent event) {
    photosDao.savePhoto(event.getUrl());
    showPhotosIfAny();

    bus.removeAllStickyEvents();
  }

  private void showPhotosIfAny() {
    updateAdapter(getListOfPhotos());
  }

  @Override public void onEventMainThread(NoPhotoAvailableEvent event) {
    view.showErrorMessage("No photo available");
  }

  @Override public void onActionButtonClick() {
    if (serviceWatcher.isServiceRunning()) {
      view.stopService();
      view.setActionButtonText("Start");
    } else {
      view.startService();
      view.setActionButtonText("Stop");
    }
  }

  @NotNull private List<String> getListOfPhotos() {
    List<String> allPhotos = photosDao.getAllPhotos();

    if (allPhotos == null) {
      return Collections.emptyList();
    }

    return allPhotos;
  }

  private void updateAdapter(@NotNull List<String> photos) {
    adapter.setData(photos);
    view.setAdapter(adapter);
  }

  private void updateUi() {
    showPhotosIfAny();
    updateActionButtonText();
  }

  private void updateActionButtonText() {
    if (serviceWatcher.isServiceRunning()) {
      view.setActionButtonText("Stop");
    }
  }
}
