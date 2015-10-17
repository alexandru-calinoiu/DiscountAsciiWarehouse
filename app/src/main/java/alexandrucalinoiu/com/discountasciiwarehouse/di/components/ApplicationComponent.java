package alexandrucalinoiu.com.discountasciiwarehouse.di.components;

import android.app.SearchManager;
import android.content.Context;

import javax.inject.Singleton;

import alexandrucalinoiu.com.discountasciiwarehouse.data.repository.AsciiRepository;
import alexandrucalinoiu.com.discountasciiwarehouse.di.modules.ApplicationModule;
import alexandrucalinoiu.com.discountasciiwarehouse.domain.executor.ExecutionThread;
import alexandrucalinoiu.com.discountasciiwarehouse.domain.executor.PostExecutionThread;
import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

  Context context();

  SearchManager searchManager();

  PostExecutionThread postExecutionThread();

  ExecutionThread executionThread();

  AsciiRepository asciiRepository();
}
