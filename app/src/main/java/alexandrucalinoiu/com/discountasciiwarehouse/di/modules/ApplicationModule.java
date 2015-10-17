package alexandrucalinoiu.com.discountasciiwarehouse.di.modules;

import android.app.SearchManager;
import android.content.Context;

import javax.inject.Singleton;

import alexandrucalinoiu.com.discountasciiwarehouse.DiscountApplication;
import alexandrucalinoiu.com.discountasciiwarehouse.JobThread;
import alexandrucalinoiu.com.discountasciiwarehouse.UIThread;
import alexandrucalinoiu.com.discountasciiwarehouse.data.repository.AsciiRepository;
import alexandrucalinoiu.com.discountasciiwarehouse.data.repository.RetroAsciiRepository;
import alexandrucalinoiu.com.discountasciiwarehouse.domain.executor.ExecutionThread;
import alexandrucalinoiu.com.discountasciiwarehouse.domain.executor.PostExecutionThread;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
  private final DiscountApplication application;

  public ApplicationModule(DiscountApplication application) {
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

  @Provides
  @Singleton
  public PostExecutionThread providePostExecutionThread(UIThread uiThread) {
    return uiThread;
  }

  @Provides
  @Singleton
  public ExecutionThread provideExecutionThread(JobThread jobThread) {
    return jobThread;
  }

  @Provides
  @Singleton
  public AsciiRepository provideAsciiRepository(RetroAsciiRepository retroAsciiRepository) {
    return retroAsciiRepository;
  }
}
