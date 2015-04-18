package gmail.ebeletskiy.routememorizer.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import butterknife.ButterKnife;
import gmail.ebeletskiy.routememorizer.R;
import gmail.ebeletskiy.routememorizer.data.api.model.Photo;
import gmail.ebeletskiy.routememorizer.modules.screens.MainModule;
import gmail.ebeletskiy.routememorizer.ui.base.InjectableFragment;
import org.jetbrains.annotations.NotNull;

public class MainFragment extends InjectableFragment implements MainView {

  @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_main, container, false);
    ButterKnife.inject(this, view);
    return view;
  }

  @Override public void setAdapter(@NotNull ArrayAdapter<Photo> adapter) {

  }

  @Override public Object getModules() {
    return new MainModule(this);
  }
}
