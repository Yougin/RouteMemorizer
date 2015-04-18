package gmail.ebeletskiy.routememorizer.ui.fragments;

import android.widget.BaseAdapter;
import org.jetbrains.annotations.NotNull;

public interface MainView {

  void setAdapter(@NotNull BaseAdapter adapter);
}
