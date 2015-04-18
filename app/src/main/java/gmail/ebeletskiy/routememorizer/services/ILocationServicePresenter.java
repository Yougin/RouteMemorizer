package gmail.ebeletskiy.routememorizer.services;

import gmail.ebeletskiy.routememorizer.events.ApiClientConnectedEvent;

public interface ILocationServicePresenter {

  void start();

  void onEvent(ApiClientConnectedEvent event);

}
