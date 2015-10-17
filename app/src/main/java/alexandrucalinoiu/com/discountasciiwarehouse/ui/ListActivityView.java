package alexandrucalinoiu.com.discountasciiwarehouse.ui;

import android.view.View;

import java.util.List;

import alexandrucalinoiu.com.discountasciiwarehouse.domain.model.Ascii;

public interface ListActivityView {
  View getView();

  void setAsciis(List<Ascii> asciis);
}
