package alexandrucalinoiu.com.discountasciiwarehouse.ui.fragment;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import alexandrucalinoiu.com.discountasciiwarehouse.R;
import alexandrucalinoiu.com.discountasciiwarehouse.di.HasComponent;
import alexandrucalinoiu.com.discountasciiwarehouse.di.components.ListActivityComponent;
import alexandrucalinoiu.com.discountasciiwarehouse.domain.model.Ascii;
import alexandrucalinoiu.com.discountasciiwarehouse.presenter.ListPresenter;
import alexandrucalinoiu.com.discountasciiwarehouse.ui.EndlessRecyclerOnScrollListener;
import alexandrucalinoiu.com.discountasciiwarehouse.ui.ListActivityView;
import alexandrucalinoiu.com.discountasciiwarehouse.ui.adapter.AsciiRecyclerAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;

public class ListActivityFragment extends Fragment implements ListActivityView {

  private LinearLayoutManager layoutManager;
  private AsciiRecyclerAdapter asciiRecyclerAdapter;

  @Bind(R.id.recyclerView)
  RecyclerView recyclerView;

  @Inject
  public ListPresenter listPresenter;

  @Inject
  public SearchManager searchManager;

  @Inject
  public Context context;

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

    ((HasComponent<ListActivityComponent>) getActivity()).getComponent().inject(this);
    this.listPresenter.setListActivityView(this);
    addOnScrollListener();
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
    View view = inflater.inflate(R.layout.fragment_list, container, false);
    ButterKnife.bind(this, view);

    setupRecyclerView();

    return view;
  }

  @Override
  public void onPause() {
    super.onPause();
    listPresenter.pause();
  }

  @Override
  public void onResume() {
    super.onResume();
    listPresenter.resume();
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    listPresenter.destroy();
  }

  public void setAsciis(List<Ascii> asciis) {
    asciiRecyclerAdapter = new AsciiRecyclerAdapter(asciis);
    recyclerView.setAdapter(asciiRecyclerAdapter);
  }

  public void addAsciis(List<Ascii> asciis) {
    asciiRecyclerAdapter.addAll(asciis);
  }

  private void setupSearchView(Menu menu) {
    SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
    searchView.setSearchableInfo(searchManager.getSearchableInfo(this.getActivity().getComponentName()));
    searchView.setOnQueryTextListener(listPresenter);
  }

  private void setupRecyclerView() {
    layoutManager = new GridLayoutManager(context, 2);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());

  }

  private void addOnScrollListener() {
    recyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(layoutManager, listPresenter));
  }
}
