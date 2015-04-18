package gmail.ebeletskiy.routememorizer.modules.screens;

import gmail.ebeletskiy.routememorizer.events.GotPhotoEvent;
import gmail.ebeletskiy.routememorizer.events.NoPhotoAvailableEvent;

public interface MainPresenter {

  void onResume();

  void onPause();

  void onEventMainThread(GotPhotoEvent event);

  void onEventMainThread(NoPhotoAvailableEvent event);

  void onActionButtonClick();
}
