package com.gigigo.dagger2sample.di.modules;

import com.gigigo.dagger2sample.data.entities.User;
import dagger.Module;
import dagger.Provides;

/**
 * Created by santiago.berrocoso on 05/10/16.
 */
@Module
public class UserModule {

  private final User user;

  public UserModule(User user) {
    this.user = user;
  }

  @Provides
  User provideUser(){
   return this.user;
  }
}
