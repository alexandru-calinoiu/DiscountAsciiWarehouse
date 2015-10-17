package alexandrucalinoiu.com.discountasciiwarehouse.ui.viewmodel;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.text.Spanned;

import alexandrucalinoiu.com.discountasciiwarehouse.R;
import alexandrucalinoiu.com.discountasciiwarehouse.domain.model.Ascii;

public class AsciiViewModel {
  private Context context;
  private final Ascii ascii;

  public AsciiViewModel(Context context, Ascii ascii) {
    this.context = context;
    this.ascii = ascii;
  }

  public String getFace() {
    return ascii.getFace();
  }

  public String getPrice() {
    return "$" + ascii.getPrice();
  }

  public Spanned getCallToAction() {
    Resources resources = context.getResources();
    String actualCallToAction = canBuy() ? resources.getString(R.string.button_buy) : resources.getString(R.string.button_out);
    String result = "<b><big>" + actualCallToAction + "</big></b>" + "<br />";

    if (ascii.getStock() == 1) {
      result +=  "<small>" + resources.getString(R.string.button_call_to_action) + "</small>" + "<br />";
    }

    return Html.fromHtml(result);
  }

  public boolean canBuy() {
    return !(ascii.getStock() == 0);
  }
}
