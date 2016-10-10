package com.gigigo.dagger2sample.di.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

/**
 * Created by santiago.berrocoso on 05/10/16.
 */
@Scope @Retention(RetentionPolicy.RUNTIME) public @interface UserScope {
}
