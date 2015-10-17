package alexandrucalinoiu.com.discountasciiwarehouse.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class EndlessRecyclerOnScrollListener extends RecyclerView.OnScrollListener {
  private int previousTotal = 0;
  private boolean loading = true;

  private int current_page = 1;

  private final LinearLayoutManager linearLayoutManager;
  private final EndOfLineListener endOfLineListener;

  public interface EndOfLineListener {
    void loadMore(int currentPage);
  }

  public EndlessRecyclerOnScrollListener(LinearLayoutManager linearLayoutManager, EndOfLineListener endOfLineListener) {
    this.linearLayoutManager = linearLayoutManager;
    this.endOfLineListener = endOfLineListener;
  }

  @Override
  public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
    super.onScrolled(recyclerView, dx, dy);

    final int visibleItemCount = recyclerView.getChildCount();
    final int totalItemCount = linearLayoutManager.getItemCount();
    final int firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();

    if (loading) {
      if (totalItemCount > previousTotal) {
        loading = false;
        previousTotal = totalItemCount;
      }
    }

    final int visibleThreshold = 2;

    if (!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
      current_page++;
      endOfLineListener.loadMore(current_page);
      loading = true;
    }
  }
}
