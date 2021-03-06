package gmail.ebeletskiy.routememorizer.ui.fragments;

import android.widget.BaseAdapter;
import org.jetbrains.annotations.NotNull;

public interface MainView {

  void setAdapter(@NotNull BaseAdapter adapter);

  void showErrorMessage(String message);

  void startService();

  void stopService();

  void setActionButtonText(String text);
}
