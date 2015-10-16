package alexandrucalinoiu.com.discountasciiwarehouse.di.components;

import alexandrucalinoiu.com.discountasciiwarehouse.di.PerActivity;
import alexandrucalinoiu.com.discountasciiwarehouse.di.modules.ActivityModule;
import alexandrucalinoiu.com.discountasciiwarehouse.di.modules.ListActivityModule;
import alexandrucalinoiu.com.discountasciiwarehouse.ui.fragment.ListActivityFragment;
import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, ListActivityModule.class})
public interface ListActivityComponent extends ActivityComponent {
  void inject(ListActivityFragment fragment);
}
