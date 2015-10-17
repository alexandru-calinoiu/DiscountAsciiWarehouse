package alexandrucalinoiu.com.discountasciiwarehouse.presenter;

import android.test.AndroidTestCase;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import alexandrucalinoiu.com.discountasciiwarehouse.domain.interaction.Search;
import alexandrucalinoiu.com.discountasciiwarehouse.ui.viewmodel.ListActivityFragmentViewModel;
import rx.Subscriber;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

public class ListPresenterTest extends AndroidTestCase {
  private ListPresenter subject;

  @Mock
  private Search mockSearch;

  @Mock
  private ListActivityFragmentViewModel listActivityFragmentViewModel;

  @Override
  public void setUp() throws Exception {
    super.setUp();
    MockitoAnnotations.initMocks(this);
    subject = new ListPresenter(mockSearch, listActivityFragmentViewModel);
  }

  public void testOnQueryTextSubmit() throws Exception {
    subject.onQueryTextSubmit("42");

    verify(listActivityFragmentViewModel).setProgressVisible();
    verify(mockSearch).execute(eq("42"), any(Subscriber.class));
  }
}