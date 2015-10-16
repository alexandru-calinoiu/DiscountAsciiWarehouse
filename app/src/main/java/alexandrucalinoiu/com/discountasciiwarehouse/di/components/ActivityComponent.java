package alexandrucalinoiu.com.discountasciiwarehouse.di.components;

import alexandrucalinoiu.com.discountasciiwarehouse.di.PerActivity;
import alexandrucalinoiu.com.discountasciiwarehouse.di.modules.ActivityModule;
import alexandrucalinoiu.com.discountasciiwarehouse.ui.activity.BaseActivity;
import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
  BaseActivity activity();
}
