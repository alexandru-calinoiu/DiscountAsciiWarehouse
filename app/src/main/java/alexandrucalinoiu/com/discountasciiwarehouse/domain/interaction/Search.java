package alexandrucalinoiu.com.discountasciiwarehouse.domain.interaction;

import rx.Subscriber;

public interface Search {
  void execute(String query, Subscriber subscription);

  void unsubscribe();
}
