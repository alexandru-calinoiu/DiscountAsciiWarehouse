package alexandrucalinoiu.com.discountasciiwarehouse.ui.viewmodel;

import android.databinding.ObservableField;
import android.view.View;

public class ListActivityFragmentViewModelImpl implements ListActivityFragmentViewModel {
  public ObservableField<Integer> observableProgressVisibility;

  public ListActivityFragmentViewModelImpl() {
    this.observableProgressVisibility = new ObservableField<>(View.GONE);
  }

  public ObservableField<Integer> getObservableProgressVisibility() {
    return observableProgressVisibility;
  }

  public void setProgressVisible() {
    observableProgressVisibility.set(View.VISIBLE);
  }

  public void setProgressGone() {
    observableProgressVisibility.set(View.GONE);
  }

}
