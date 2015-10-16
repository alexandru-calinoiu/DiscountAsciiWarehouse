package alexandrucalinoiu.com.discountasciiwarehouse.di.modules;

import android.app.SearchManager;
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

  @Provides
  @Singleton
  public SearchManager provideSearchManager() {
    return (SearchManager) application.getSystemService(Context.SEARCH_SERVICE);
  }
}
