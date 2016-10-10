package com.gigigo.dagger2sample.di.modules;

import android.app.Application;
import android.content.Context;
import com.gigigo.dagger2sample.data.api.services.ApiService;
import com.gigigo.dagger2sample.data.api.services.SpotifyApiService;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import retrofit2.Retrofit;

/**
 * Created by santiago.berrocoso on 04/10/16.
 * Common Appmodule witch contains all Object useful by all class.
 */
@Module public class ApplicationModule {

  private Application application;

  public ApplicationModule(Application application) {
    this.application = application;
  }

  @Provides @Singleton public Application provideApplication() {
    return application;
  }

  @Singleton @Provides Context provideContext() {
    return application;
  }

  @Singleton @Provides Retrofit provideRetrofitInstance() {
    return ApiService.getInstance();
  }

  @Provides @Singleton public SpotifyApiService provideSpotifyApiService(Retrofit retrofit) {
    return retrofit.create(SpotifyApiService.class);
  }
}
