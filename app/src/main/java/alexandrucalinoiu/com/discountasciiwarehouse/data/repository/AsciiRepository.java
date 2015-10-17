package alexandrucalinoiu.com.discountasciiwarehouse.data.repository;

import java.util.List;

import alexandrucalinoiu.com.discountasciiwarehouse.domain.model.Ascii;
import alexandrucalinoiu.com.discountasciiwarehouse.domain.model.QueryParams;
import rx.Observable;

public interface AsciiRepository {
  Observable<List<Ascii>> search(QueryParams params);
}
