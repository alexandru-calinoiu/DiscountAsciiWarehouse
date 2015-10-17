package alexandrucalinoiu.com.discountasciiwarehouse.domain.executor;

import rx.Scheduler;

public interface ExecutionThread {
  Scheduler getScheduler();
}
