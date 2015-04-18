package gmail.ebeletskiy.routememorizer.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import dagger.ObjectGraph;
import gmail.ebeletskiy.routememorizer.App;

@SuppressWarnings("AbstractClassExtendsConcreteClass")
public abstract class InjectableFragment extends Fragment {

  protected ObjectGraph scopedGraph;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    scopedGraph = ((App) getActivity().getApplication()).createScopedGraph(getModules());
    scopedGraph.inject(this);
  }

  @Override public void onDestroy() {
    super.onDestroy();
    scopedGraph = null;
  }

  public abstract Object getModules();

}
