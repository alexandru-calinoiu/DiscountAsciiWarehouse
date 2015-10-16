package alexandrucalinoiu.com.discountasciiwarehouse.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;

import alexandrucalinoiu.com.discountasciiwarehouse.DiscountApplication;
import alexandrucalinoiu.com.discountasciiwarehouse.R;
import alexandrucalinoiu.com.discountasciiwarehouse.di.components.ApplicationComponent;

public abstract class BaseActivity extends AppCompatActivity {

  public ApplicationComponent getApplicationComponent() {
    return ((DiscountApplication) getApplication()).getApplicationComponent();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    requestWindowFeature(Window.FEATURE_ACTION_BAR);

    super.onCreate(savedInstanceState);
    setContentView(getLayoutResId());

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
  }

  protected abstract int getLayoutResId();
}
