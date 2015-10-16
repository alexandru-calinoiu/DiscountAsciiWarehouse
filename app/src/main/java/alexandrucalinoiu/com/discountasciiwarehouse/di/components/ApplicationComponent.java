package alexandrucalinoiu.com.discountasciiwarehouse.di.components;

import android.content.Context;

import javax.inject.Singleton;

import alexandrucalinoiu.com.discountasciiwarehouse.di.modules.ApplicantionModule;
import dagger.Component;

@Singleton
@Component(modules = ApplicantionModule.class)
public interface ApplicationComponent {

  Context context();
}
