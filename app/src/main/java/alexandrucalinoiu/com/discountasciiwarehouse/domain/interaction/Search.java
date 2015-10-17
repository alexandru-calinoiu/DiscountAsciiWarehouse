package alexandrucalinoiu.com.discountasciiwarehouse.domain.interaction;

import alexandrucalinoiu.com.discountasciiwarehouse.domain.model.QueryParams;
import rx.Subscriber;

public interface Search {
  void execute(QueryParams params, Subscriber subscription);

  void unsubscribe();
}
