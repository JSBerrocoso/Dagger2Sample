package com.gigigo.dagger2sample.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.preference.PreferenceManager;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by santiago.berrocoso on 04/10/16.
 */
@Module public class ApplicationModule {

  Application application;

  public ApplicationModule(Application application) {
    this.application = application;
  }

  @Provides Context provideApplicationContext() {
    return application;
  }

  @Singleton @Provides ConnectivityManager provideConnectivityManager() {
    return (ConnectivityManager) application.getSystemService(Context.CONNECTIVITY_SERVICE);
  }

  @Singleton @Provides SharedPreferences providePreferenceManager() {
    return PreferenceManager.getDefaultSharedPreferences(application);
  }
}
