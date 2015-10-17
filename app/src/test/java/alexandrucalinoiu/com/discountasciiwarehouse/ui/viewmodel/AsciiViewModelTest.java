package alexandrucalinoiu.com.discountasciiwarehouse.ui.viewmodel;

import junit.framework.TestCase;

import alexandrucalinoiu.com.discountasciiwarehouse.domain.model.Ascii;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AsciiViewModelTest extends TestCase {
  private AsciiViewModel subject;

  public void testGetFaceAlwaysReturnsTheFace() throws Exception {
    Ascii ascii = new Ascii();
    ascii.setFace("0.O");

    subject = new AsciiViewModel(ascii);

    assertThat(subject.getFace(), is("0.O"));
  }

  public void testGetPriceAlwaysReturnsThePricePrefixed() {
    Ascii ascii = new Ascii();
    ascii.setPrice(42);

    subject = new AsciiViewModel(ascii);

    assertThat(subject.getPrice(), is("$42"));
  }
}