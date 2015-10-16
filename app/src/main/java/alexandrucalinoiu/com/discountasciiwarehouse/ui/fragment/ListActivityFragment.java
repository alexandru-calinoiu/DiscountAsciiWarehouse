package alexandrucalinoiu.com.discountasciiwarehouse.ui.fragment;

import android.app.SearchManager;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import alexandrucalinoiu.com.discountasciiwarehouse.R;
import alexandrucalinoiu.com.discountasciiwarehouse.di.HasComponent;
import alexandrucalinoiu.com.discountasciiwarehouse.di.components.ListActivityComponent;
import alexandrucalinoiu.com.discountasciiwarehouse.presenter.ListPresenter;
import alexandrucalinoiu.com.discountasciiwarehouse.ui.activity.BaseActivity;
import alexandrucalinoiu.com.discountasciiwarehouse.ui.activity.ListActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class ListActivityFragment extends Fragment {

  @Inject
  public ListPresenter listPresenter;

  @Inject
  public SearchManager searchManager;

  public ListActivityFragment() {
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
  }

  @Override
  @SuppressWarnings("unchecked")
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    ((HasComponent<ListActivityComponent>)getActivity()).getComponent().inject(this);
  }

  @Override
  public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    super.onCreateOptionsMenu(menu, inflater);
    inflater.inflate(R.menu.menu_fragment_list, menu);

    setupSearchView(menu);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_list, container, false);
  }

  private void setupSearchView(Menu menu) {
    SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
    searchView.setSearchableInfo(searchManager.getSearchableInfo(this.getActivity().getComponentName()));
    searchView.setOnQueryTextListener(listPresenter);
  }
}
