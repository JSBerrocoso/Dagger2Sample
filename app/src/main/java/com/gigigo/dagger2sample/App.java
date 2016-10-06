package com.gigigo.dagger2sample;

import android.app.Application;
import com.gigigo.dagger2sample.data.entities.User;
import com.gigigo.dagger2sample.di.components.ApplicationComponent;
import com.gigigo.dagger2sample.di.components.DaggerApplicationComponent;
import com.gigigo.dagger2sample.di.components.UserSubComponent;
import com.gigigo.dagger2sample.di.modules.ApplicationModule;
import com.gigigo.dagger2sample.di.modules.UserModule;

/**
 * Created by santiago.berrocoso on 04/10/16.
 */

public class App extends Application {

  private ApplicationComponent applicationComponent;

  private UserSubComponent userSubComponent;

  @Override public void onCreate() {
    super.onCreate();

    initDI();
  }

  private void initDI() {
    this.applicationComponent =
        DaggerApplicationComponent.builder()
            .applicationModule(
                new ApplicationModule(this))
            .build();
  }

  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }

  public UserSubComponent createUserSubComponent(User user) {
    userSubComponent = applicationComponent.plus(new UserModule(user));
    return userSubComponent;
  }

  public void releaseUserComponent() {
    userSubComponent = null;
  }

  public UserSubComponent getUserSubComponent() {
    return userSubComponent;
  }
}
