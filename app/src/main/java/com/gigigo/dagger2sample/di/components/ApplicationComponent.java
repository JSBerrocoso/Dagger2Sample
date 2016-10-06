package com.gigigo.dagger2sample.di.components;

import com.gigigo.dagger2sample.di.modules.ApplicationModule;
import com.gigigo.dagger2sample.di.modules.UserModule;
import com.gigigo.dagger2sample.ui.MainActivity;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by santiago.berrocoso on 04/10/16.
 */
@Singleton
@Component(modules = { ApplicationModule.class })
public interface ApplicationComponent {

  void inject(MainActivity activity);

  UserSubComponent plus(UserModule userModule);
}
