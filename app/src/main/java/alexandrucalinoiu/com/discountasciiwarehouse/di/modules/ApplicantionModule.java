package alexandrucalinoiu.com.discountasciiwarehouse.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import alexandrucalinoiu.com.discountasciiwarehouse.DiscountApplication;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicantionModule {
  private final DiscountApplication application;

  public ApplicantionModule(DiscountApplication application) {
    this.application = application;
  }

  @Provides
  @Singleton
  public Context provideApplicationContext() {
    return this.application;
  }
}
