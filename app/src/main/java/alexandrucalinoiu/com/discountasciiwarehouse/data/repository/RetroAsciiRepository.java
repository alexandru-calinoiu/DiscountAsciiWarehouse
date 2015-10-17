package alexandrucalinoiu.com.discountasciiwarehouse.data.repository;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import alexandrucalinoiu.com.discountasciiwarehouse.data.converter.AsciiResponseConverter;
import alexandrucalinoiu.com.discountasciiwarehouse.domain.model.Ascii;
import alexandrucalinoiu.com.discountasciiwarehouse.domain.model.QueryParams;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Query;
import rx.Observable;

@Singleton
public class RetroAsciiRepository implements AsciiRepository {

  private final AsciiService asciiService;
  private Context context;

  public interface AsciiService {
    @Headers({
        "Content-Type: application/json"
    })
    @GET("/search.json")
    Observable<List<Ascii>> search(@Query("limit") int limit, @Query("skip") int skip, @Query("q") String query);
  }

  @Inject
  public RetroAsciiRepository(Context context) {
    this.context = context;

    RestAdapter retrofit = new RestAdapter.Builder()
        .setEndpoint("http://74.50.59.155:5000/api")
        .setClient(new OkClient(buildOkClient()))
        .setRequestInterceptor(buildRequestInterceptor())
        .setLogLevel(RestAdapter.LogLevel.FULL)
        .setConverter(new AsciiResponseConverter())
        .build();

    asciiService = retrofit.create(AsciiService.class);
  }

  private RequestInterceptor buildRequestInterceptor() {
    return new RequestInterceptor() {
      @Override
      public void intercept(RequestInterceptor.RequestFacade request) {
        request.addHeader("Content-Type", "application/json; charset=utf8");
        if (isNetworkAvailable(context)) {
          int maxAge = 0;
          request.addHeader("Cache-Control", "public, max-age=" + maxAge);
        } else {
          int maxStale = 60;
          request.addHeader("Cache-Control", "public, only-if-cached, max-stale=" + maxStale);
        }
      }
    };
  }

  private boolean isNetworkAvailable(Context context) {
    ConnectivityManager cm =
        (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo netInfo = cm.getActiveNetworkInfo();
    return netInfo != null && netInfo.isConnectedOrConnecting();
  }

  private OkHttpClient buildOkClient() {
    OkHttpClient client = new OkHttpClient();
    File httpCacheDirectory = new File(context.getCacheDir(), "responses");
    Cache cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);

    client.setCache(cache);

    return client;
  }

  public Observable<List<Ascii>> search(QueryParams params) {
    return asciiService.search(params.getLimit(), params.getSkip(), params.getQuery());
  }
}
