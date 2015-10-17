package alexandrucalinoiu.com.discountasciiwarehouse.ui.activity;

import android.os.Bundle;
import android.view.Menu;

import alexandrucalinoiu.com.discountasciiwarehouse.R;
import alexandrucalinoiu.com.discountasciiwarehouse.di.HasComponent;
import alexandrucalinoiu.com.discountasciiwarehouse.di.components.DaggerListActivityComponent;
import alexandrucalinoiu.com.discountasciiwarehouse.di.components.ListActivityComponent;
import alexandrucalinoiu.com.discountasciiwarehouse.di.modules.ActivityModule;

public class ListActivity extends BaseActivity implements HasComponent<ListActivityComponent> {

  private ListActivityComponent listActivityComponent;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    listActivityComponent = DaggerListActivityComponent.builder()
        .applicationComponent(getApplicationComponent())
        .activityModule(new ActivityModule(this))
        .build();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_list, menu);

    return true;
  }

  @Override
  public ListActivityComponent getComponent() {
    return this.listActivityComponent;
  }

  @Override
  protected int getLayoutResId() {
    return R.layout.activity_list;
  }
}
