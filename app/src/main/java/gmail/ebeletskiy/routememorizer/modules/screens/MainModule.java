package gmail.ebeletskiy.routememorizer.modules.screens;

import dagger.Module;
import dagger.Provides;
import gmail.ebeletskiy.routememorizer.modules.ApplicationModule;
import gmail.ebeletskiy.routememorizer.ui.fragments.MainFragment;
import gmail.ebeletskiy.routememorizer.ui.fragments.MainView;
import javax.inject.Singleton;

@Module(injects = MainFragment.class,
    addsTo = ApplicationModule.class,
    library = true,
    complete = false)
public class MainModule {

  private final MainView view;

  public MainModule(MainView view) {
    this.view = view;
  }

  @Provides @Singleton MainView provideView() {
    return view;
  }

  @Provides @Singleton MainPresenter providePresenter(MainPresenterImpl presenter) {
    return presenter;
  }
}
