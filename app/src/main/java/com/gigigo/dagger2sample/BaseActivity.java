package com.gigigo.dagger2sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.gigigo.dagger2sample.di.components.ApplicationComponent;

/**
 * Created by santiago.berrocoso on 05/10/16.
 */
public class BaseActivity extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }


  public ApplicationComponent getApplicationComponent() {
    return ((App) getApplication()).getApplicationComponent();
  }

  protected App getApp() {
    return (App) getApplication();
  }
}
