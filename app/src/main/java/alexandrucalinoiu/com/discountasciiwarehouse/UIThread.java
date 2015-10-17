package alexandrucalinoiu.com.discountasciiwarehouse;

import javax.inject.Inject;
import javax.inject.Singleton;

import alexandrucalinoiu.com.discountasciiwarehouse.domain.executor.PostExecutionThread;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

@Singleton
public class UIThread implements PostExecutionThread {

  @Inject
  public UIThread() {
  }

  @Override
  public Scheduler getScheduler() {
    return AndroidSchedulers.mainThread();
  }
}
