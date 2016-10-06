package com.gigigo.dagger2sample.data.preferences;

import com.gigigo.dagger2sample.data.entities.User;
import com.gigigo.dagger2sample.di.scopes.UserScope;
import javax.inject.Inject;

/**
 * Created by santiago.berrocoso on 05/10/16.
 */

@UserScope public class UserPreferencesManager {

  private User user;

  @Inject public UserPreferencesManager(User user) {
    this.user = user;
  }

  public String getHelloMessage() {
    return "Hello \n " + user.getName();
  }
}
