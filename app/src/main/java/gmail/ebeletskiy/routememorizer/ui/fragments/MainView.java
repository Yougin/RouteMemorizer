package gmail.ebeletskiy.routememorizer.ui.fragments;

import android.widget.ArrayAdapter;
import gmail.ebeletskiy.routememorizer.data.api.model.Photo;
import org.jetbrains.annotations.NotNull;

public interface MainView {

  void setAdapter(@NotNull ArrayAdapter<Photo> adapter);

}
