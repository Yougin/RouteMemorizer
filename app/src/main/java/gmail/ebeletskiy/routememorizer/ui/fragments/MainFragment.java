package gmail.ebeletskiy.routememorizer.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import gmail.ebeletskiy.routememorizer.R;
import gmail.ebeletskiy.routememorizer.modules.screens.MainModule;
import gmail.ebeletskiy.routememorizer.modules.screens.MainPresenter;
import gmail.ebeletskiy.routememorizer.services.LocationService;
import gmail.ebeletskiy.routememorizer.ui.base.InjectableFragment;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;

public class MainFragment extends InjectableFragment implements MainView {

  @Inject MainPresenter presenter;
  @InjectView(R.id.main_listview) ListView listView;
  @InjectView(R.id.main_action_button) Button actionButton;

  @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_main, container, false);
    ButterKnife.inject(this, view);
    return view;
  }

  @Override public void onResume() {
    super.onResume();
    presenter.onResume();
  }

  @Override public void onPause() {
    super.onPause();
    presenter.onPause();
  }

  @Override public void setAdapter(@NotNull BaseAdapter adapter) {
    listView.setAdapter(adapter);
  }

  @OnClick(R.id.main_action_button) void onActionButtonClick() {
    presenter.onActionButtonClick();
  }

  @Override public void showErrorMessage(String message) {
    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
  }

  @Override public void startService() {
    // TODO: move up to Activity level
    getActivity().startService(new Intent(getActivity(), LocationService.class));
  }

  @Override public void stopService() {
    // TODO: move up to Activity level
    getActivity().stopService(new Intent(getActivity(), LocationService.class));
  }

  @Override public void setActionButtonText(String text) {
    actionButton.setText(text);
  }

  @Override public Object getModules() {
    return new MainModule(this);
  }
}
