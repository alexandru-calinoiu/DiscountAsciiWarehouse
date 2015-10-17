package alexandrucalinoiu.com.discountasciiwarehouse.ui.viewmodel;

import android.text.Html;
import android.text.Spanned;

import alexandrucalinoiu.com.discountasciiwarehouse.domain.model.Ascii;

public class AsciiViewModel {
  private final Ascii ascii;

  public AsciiViewModel(Ascii ascii) {
    this.ascii = ascii;
  }

  public String getFace() {
    return ascii.getFace();
  }

  public String getPrice() {
    return "$" + ascii.getPrice();
  }

  public Spanned getCallToAction() {
    String actualCallToAction = canBuy() ? "Buy now!" : "Out of stock!";
    String result = "<b><big>" + actualCallToAction + "</big></b>" + "<br />";

    if (ascii.getStock() == 1) {
      result +=  "<small>" + "(only 1 more in stock" + "</small>" + "<br />";
    }

    return Html.fromHtml(result);
  }

  public boolean canBuy() {
    return !(ascii.getStock() == 0);
  }
}
