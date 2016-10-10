package com.gigigo.dagger2sample.domain.callbacks;

/**
 * Created by santiago.berrocoso on 07/10/16.
 */
public interface ServerCallback {

  void onNetworkError();
  void onServerError();
}
