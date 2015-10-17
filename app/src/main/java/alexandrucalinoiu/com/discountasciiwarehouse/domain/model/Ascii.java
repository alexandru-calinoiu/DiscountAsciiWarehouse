package alexandrucalinoiu.com.discountasciiwarehouse.domain.model;

public class Ascii {
  private String face;
  private Integer price;
  private Integer stock;

  public Ascii() {
  }

  public String getFace() {
    return face;
  }

  public void setFace(String face) {
    this.face = face;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }
}
