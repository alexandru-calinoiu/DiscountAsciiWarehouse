package alexandrucalinoiu.com.discountasciiwarehouse.domain.interaction;

import javax.inject.Inject;

import alexandrucalinoiu.com.discountasciiwarehouse.data.repository.AsciiRepository;
import alexandrucalinoiu.com.discountasciiwarehouse.domain.executor.ExecutionThread;
import alexandrucalinoiu.com.discountasciiwarehouse.domain.executor.PostExecutionThread;
import alexandrucalinoiu.com.discountasciiwarehouse.domain.model.QueryParams;
import rx.Subscriber;
import rx.Subscription;

public class SearchUseCase implements Search {
  private final ExecutionThread executionThread;
  private final PostExecutionThread postExecutionThread;
  private AsciiRepository asciiRepository;

  private Subscription subscription;

  @Inject
  public SearchUseCase(AsciiRepository asciiRepository, ExecutionThread executionThread, PostExecutionThread postExecutionThread) {
    this.executionThread = executionThread;
    this.postExecutionThread = postExecutionThread;
    this.asciiRepository = asciiRepository;
  }

  @SuppressWarnings("unchecked")
  public void execute(QueryParams params, Subscriber subscriber) {
    subscription = asciiRepository.search(params)
        .subscribeOn(executionThread.getScheduler())
        .observeOn(postExecutionThread.getScheduler())
        .subscribe(subscriber);
  }

  public void unsubscribe() {
    if (subscription != null) {
      subscription.unsubscribe();
    }
  }
}
