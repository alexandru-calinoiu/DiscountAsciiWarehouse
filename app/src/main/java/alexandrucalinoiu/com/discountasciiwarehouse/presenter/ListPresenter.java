package alexandrucalinoiu.com.discountasciiwarehouse.presenter;

import android.support.v7.widget.SearchView;

import javax.inject.Inject;

import alexandrucalinoiu.com.discountasciiwarehouse.di.PerActivity;

@PerActivity
public class ListPresenter implements SearchView.OnQueryTextListener {
  @Inject
  public ListPresenter() {
  }

  @Override
  public boolean onQueryTextSubmit(String query) {
    return false;
  }

  @Override
  public boolean onQueryTextChange(String newText) {
    return false;
  }
}
