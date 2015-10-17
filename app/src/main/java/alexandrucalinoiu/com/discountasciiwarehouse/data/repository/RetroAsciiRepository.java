package alexandrucalinoiu.com.discountasciiwarehouse.data.repository;

import com.squareup.okhttp.OkHttpClient;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import alexandrucalinoiu.com.discountasciiwarehouse.data.converter.AsciiResponseConverter;
import alexandrucalinoiu.com.discountasciiwarehouse.domain.model.Ascii;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.http.GET;
import retrofit.http.Headers;
import rx.Observable;

@Singleton
public class RetroAsciiRepository implements AsciiRepository {

  private final AsciiService asciiService;

  public interface AsciiService {
    @Headers({
        "Content-Type: application/json"
    })
    @GET("/search.json")
    Observable<List<Ascii>> search();
  }

  @Inject
  public RetroAsciiRepository() {
    OkHttpClient client = new OkHttpClient();

    RestAdapter retrofit = new RestAdapter.Builder()
        .setEndpoint("http://74.50.59.155:5000/api")
        .setClient(new OkClient(client))
        .setLogLevel(RestAdapter.LogLevel.FULL)
        .setConverter(new AsciiResponseConverter())
        .build();

    asciiService = retrofit.create(AsciiService.class);
  }

  public Observable<List<Ascii>> search() {
    return asciiService.search();
  }
}
