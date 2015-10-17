package alexandrucalinoiu.com.discountasciiwarehouse.presenter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.SearchView;

import java.util.List;

import javax.inject.Inject;

import alexandrucalinoiu.com.discountasciiwarehouse.databinding.FragmentListBinding;
import alexandrucalinoiu.com.discountasciiwarehouse.di.PerActivity;
import alexandrucalinoiu.com.discountasciiwarehouse.domain.interaction.Search;
import alexandrucalinoiu.com.discountasciiwarehouse.domain.model.Ascii;
import alexandrucalinoiu.com.discountasciiwarehouse.ui.ListActivityView;
import alexandrucalinoiu.com.discountasciiwarehouse.ui.viewmodel.ListActivityFragmentViewModel;

@PerActivity
public class ListPresenter implements SearchView.OnQueryTextListener, Presenter {
  private final Search search;
  private final ListActivityFragmentViewModel listActivityFragmentViewModel;
  private ListActivityView listActivityView;

  @Inject
  public ListPresenter(Search search, ListActivityFragmentViewModel listActivityFragmentViewModel) {
    this.search = search;
    this.listActivityFragmentViewModel = listActivityFragmentViewModel;
  }

  public void setListActivityView(@NonNull ListActivityView listActivityView) {
    this.listActivityView = listActivityView;
    setupBinding(listActivityView);

    onQueryTextSubmit("");
  }

  @Override
  public boolean onQueryTextSubmit(String query) {
    showLoading();
    search.execute(query, new SearchSubscriber());
    return false;
  }

  @Override
  public boolean onQueryTextChange(String newText) {
    return false;
  }

  @Override
  public void resume() {
  }

  @Override
  public void pause() {
  }

  @Override
  public void destroy() {
    search.unsubscribe();
  }

  private void showLoading() {
    this.listActivityFragmentViewModel.setProgressVisible();
  }

  private void hideLoading() {
    this.listActivityFragmentViewModel.setProgressGone();
  }

  private void showError() {
    Snackbar.make(listActivityView.getView(), "Search failed, sorry...", Snackbar.LENGTH_LONG).show();
  }

  private void setAsciis(List<Ascii> asciis) {
    listActivityView.setAsciis(asciis);
  }

  private void setupBinding(ListActivityView view) {
    FragmentListBinding binding = DataBindingUtil.bind(view.getView());
    binding.setViewModel(listActivityFragmentViewModel);
  }

  private final class SearchSubscriber extends rx.Subscriber<List<Ascii>> {
    @Override
    public void onCompleted() {
      ListPresenter.this.hideLoading();
    }

    @Override
    public void onError(Throwable e) {
      ListPresenter.this.hideLoading();
      ListPresenter.this.showError();
    }

    @Override
    public void onNext(List<Ascii> asciis) {
      ListPresenter.this.hideLoading();
      ListPresenter.this.setAsciis(asciis);
    }
  }
}
