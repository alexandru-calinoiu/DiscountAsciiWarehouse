package alexandrucalinoiu.com.discountasciiwarehouse.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by calin on 16.10.2015.
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}
