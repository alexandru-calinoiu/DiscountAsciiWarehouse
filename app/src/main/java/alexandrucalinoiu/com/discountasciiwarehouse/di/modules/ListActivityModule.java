package alexandrucalinoiu.com.discountasciiwarehouse.di.modules;

import alexandrucalinoiu.com.discountasciiwarehouse.data.repository.AsciiRepository;
import alexandrucalinoiu.com.discountasciiwarehouse.di.PerActivity;
import alexandrucalinoiu.com.discountasciiwarehouse.domain.executor.ExecutionThread;
import alexandrucalinoiu.com.discountasciiwarehouse.domain.executor.PostExecutionThread;
import alexandrucalinoiu.com.discountasciiwarehouse.domain.interaction.Search;
import alexandrucalinoiu.com.discountasciiwarehouse.domain.interaction.SearchUseCase;
import alexandrucalinoiu.com.discountasciiwarehouse.ui.viewmodel.ListActivityFragmentViewModel;
import alexandrucalinoiu.com.discountasciiwarehouse.ui.viewmodel.ListActivityFragmentViewModelImpl;
import dagger.Module;
import dagger.Provides;

@Module
public class ListActivityModule {
  @Provides
  @PerActivity
  public Search provideSearchUseCase(AsciiRepository asciiRepository, ExecutionThread executionThread, PostExecutionThread postExecutionThread) {
    return new SearchUseCase(asciiRepository, executionThread, postExecutionThread);
  }

  @Provides
  @PerActivity
  public ListActivityFragmentViewModel provideViewModel() {
    return new ListActivityFragmentViewModelImpl();
  }
}
