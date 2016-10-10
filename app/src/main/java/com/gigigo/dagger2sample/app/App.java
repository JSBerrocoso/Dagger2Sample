package com.gigigo.dagger2sample.app;

import android.app.Application;
import android.content.Context;
import com.gigigo.dagger2sample.di.components.ApplicationComponent;
import com.gigigo.dagger2sample.di.components.DaggerApplicationComponent;
import com.gigigo.dagger2sample.di.modules.ApplicationModule;

/**
 * Created by santiago.berrocoso on 04/10/16.
 */

public class App extends Application {

  private ApplicationComponent applicationComponent;

  public static App getApp(Context context) {
    return (App) context.getApplicationContext();
  }

  @Override public void onCreate() {
    super.onCreate();

    initDI();
  }

  private void initDI() {
    this.applicationComponent =
        DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
  }

  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }
}
