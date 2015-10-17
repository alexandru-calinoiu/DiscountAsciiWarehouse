package alexandrucalinoiu.com.discountasciiwarehouse;

import javax.inject.Inject;
import javax.inject.Singleton;

import alexandrucalinoiu.com.discountasciiwarehouse.domain.executor.ExecutionThread;
import rx.Scheduler;
import rx.schedulers.Schedulers;

@Singleton
public class JobThread implements ExecutionThread {

  @Inject
  public JobThread() {
  }

  @Override
  public Scheduler getScheduler() {
    return Schedulers.newThread();
  }
}
