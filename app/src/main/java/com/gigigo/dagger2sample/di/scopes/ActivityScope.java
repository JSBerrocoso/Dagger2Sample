package com.gigigo.dagger2sample.di.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

/**
 * Created by santiago.berrocoso López on 08/05/2015.
 */
@Scope @Retention(RetentionPolicy.RUNTIME) public @interface ActivityScope {
}