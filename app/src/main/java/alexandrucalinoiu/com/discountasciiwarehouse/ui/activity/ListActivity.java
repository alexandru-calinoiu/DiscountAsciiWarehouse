package alexandrucalinoiu.com.discountasciiwarehouse.ui.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_list, menu);

    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up buy_button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
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
