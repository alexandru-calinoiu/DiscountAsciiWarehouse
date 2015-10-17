package alexandrucalinoiu.com.discountasciiwarehouse.ui.viewmodel;

import android.databinding.ObservableField;

public interface ListActivityFragmentViewModel {
  ObservableField<Integer> getObservableProgressVisibility();

  void setProgressVisible();

  void setProgressGone();
}
