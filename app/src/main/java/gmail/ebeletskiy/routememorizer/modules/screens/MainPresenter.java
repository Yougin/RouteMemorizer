package gmail.ebeletskiy.routememorizer.modules.screens;

import gmail.ebeletskiy.routememorizer.events.RefreshPhotosEvent;

public interface MainPresenter {

  void onResume();

  void onPause();

  void onEventMainThread(RefreshPhotosEvent event);

}
