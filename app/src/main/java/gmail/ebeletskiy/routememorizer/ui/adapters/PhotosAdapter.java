package gmail.ebeletskiy.routememorizer.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import gmail.ebeletskiy.routememorizer.R;
import gmail.ebeletskiy.routememorizer.utils.helpers.Preconditions;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;

public class PhotosAdapter extends BaseAdapter {

  private final LayoutInflater inflater;
  private final Picasso picasso;
  private List<String> urls;

  @Inject public PhotosAdapter(LayoutInflater inflater, Picasso picasso) {
    this.inflater = Preconditions.checkNotNull(inflater);
    this.picasso = Preconditions.checkNotNull(picasso);
  }

  public void setData(@NotNull List<String> photos) {
    Collections.reverse(photos);
    this.urls = photos;
  }

  @Override public int getCount() {
    return urls.size();
  }

  @Override public Object getItem(int position) {
    return urls.get(position);
  }

  @Override public long getItemId(int position) {
    return position;
  }

  @Override public View getView(int position, View convertView, ViewGroup parent) {
    ImageView view;
    if (convertView == null) {
      view = (ImageView) inflater.inflate(R.layout.view_adapter_photo, null);
    } else {
      view = (ImageView) convertView;
    }

    picasso.load(urls.get(position)).into(view);

    return view;
  }
}
