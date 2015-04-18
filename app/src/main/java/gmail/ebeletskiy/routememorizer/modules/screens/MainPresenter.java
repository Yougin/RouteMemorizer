package gmail.ebeletskiy.routememorizer.modules.screens;

import gmail.ebeletskiy.routememorizer.events.GotPhotoEvent;

public interface MainPresenter {

  void onResume();

  void onPause();

  void onEventMainThread(GotPhotoEvent event);

}
