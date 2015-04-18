package gmail.ebeletskiy.routememorizer.modules.screens;

import com.google.common.base.Preconditions;
import de.greenrobot.event.EventBus;
import gmail.ebeletskiy.routememorizer.events.RefreshPhotosEvent;
import gmail.ebeletskiy.routememorizer.ui.fragments.MainView;
import javax.inject.Inject;

public class MainPresenterImpl implements MainPresenter {

  private final MainView view;
  private final EventBus bus;

  @Inject public MainPresenterImpl(MainView view, EventBus bus) {
    this.bus = Preconditions.checkNotNull(bus);
    this.view = Preconditions.checkNotNull(view);
  }

  @Override public void onResume() {
    bus.registerSticky(this);
  }

  @Override public void onPause() {
    bus.unregister(this);
  }

  @Override public void onEventMainThread(RefreshPhotosEvent event) {
    getListOfPhotos();
    updateAdapter();
  }

  private void getListOfPhotos() {
    // TODO: implement me

  }

  private void updateAdapter() {
    // TODO: implement me

  }
}
