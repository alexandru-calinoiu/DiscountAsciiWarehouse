package alexandrucalinoiu.com.discountasciiwarehouse.domain.model;

public class QueryParams {
  public static final int LIMIT = 10;

  private int limit;
  private int skip;
  private String query;

  public QueryParams() {
    this(LIMIT, 0, "");
  }

  public QueryParams(String query) {
    this(LIMIT, 0, query);
  }

  public QueryParams(int limit, int skip, String query) {
    this.limit = limit;
    this.skip = skip;
    this.query = query;
  }

  public int getLimit() {
    return limit;
  }

  public int getSkip() {
    return skip;
  }

  public String getQuery() {
    return query;
  }
}
