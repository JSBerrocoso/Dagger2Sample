package com.gigigo.dagger2sample.di.components;

import com.gigigo.dagger2sample.di.modules.UserModule;
import com.gigigo.dagger2sample.di.scopes.UserScope;
import com.gigigo.dagger2sample.ui.MainActivity;
import com.gigigo.dagger2sample.ui.UserActivity;
import dagger.Subcomponent;

/**
 * Created by santiago.berrocoso on 05/10/16.
 */

@UserScope
@Subcomponent(modules ={
    UserModule.class
})
public interface UserSubComponent {
  void inject( UserActivity activity);
  void inject( MainActivity activity);

}
