package alexandrucalinoiu.com.discountasciiwarehouse;

import android.app.Application;

import alexandrucalinoiu.com.discountasciiwarehouse.di.components.ApplicationComponent;
import alexandrucalinoiu.com.discountasciiwarehouse.di.components.DaggerApplicationComponent;
import alexandrucalinoiu.com.discountasciiwarehouse.di.modules.ApplicantionModule;

public class DiscountApplication extends Application {

  private ApplicationComponent applicationComponent;

  @Override
  public void onCreate() {
    super.onCreate();
    buildComponent();
  }

  private void buildComponent() {
    applicationComponent = DaggerApplicationComponent.builder()
        .applicantionModule(new ApplicantionModule(this))
        .build();
  }

  public ApplicationComponent getApplicationComponent() {
    return this.applicationComponent;
  }
}
