package alexandrucalinoiu.com.discountasciiwarehouse.di.modules;

import alexandrucalinoiu.com.discountasciiwarehouse.di.PerActivity;
import alexandrucalinoiu.com.discountasciiwarehouse.ui.activity.BaseActivity;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

  private BaseActivity activity;

  public ActivityModule(BaseActivity activity) {
    this.activity = activity;
  }

  @PerActivity
  @Provides
  public BaseActivity provideActivity() {
    return this.activity;
  }
}
