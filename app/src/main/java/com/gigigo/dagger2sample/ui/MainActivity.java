package com.gigigo.dagger2sample.ui;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.gigigo.dagger2sample.BaseActivity;
import com.gigigo.dagger2sample.R;
import com.gigigo.dagger2sample.data.entities.User;
import com.gigigo.dagger2sample.di.components.UserSubComponent;
import javax.inject.Inject;

/**
 * Created by santiago.berrocoso on 04/10/16.
 */
public class MainActivity extends BaseActivity {

  private static final String TAG = MainActivity.class.getSimpleName();

  @BindView(R.id.text_title_title) TextView text_title_title;
  @BindView(R.id.textViewName) TextView textName;

  @Inject ConnectivityManager connectivityManager;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_activity);
    ButterKnife.bind(this);
    getApplicationComponent().inject(MainActivity.this);


    boolean activeNetworkMetered = connectivityManager.isActiveNetworkMetered();
    Log.d(TAG, "activeNetworkMetered: " + activeNetworkMetered);

    text_title_title.setText(getString(R.string.text_active_network) + " " + activeNetworkMetered);
  }

  @OnClick(R.id.button_login) public void onClick(View view) {
    Intent intent = new Intent(this, UserActivity.class);
    intent.putExtra("user", new User("JSBerrocoso"));
    startActivity(intent);
  }

  @Override protected void onResume() {
    super.onResume();
    UserSubComponent userSubComponent = getApp().getUserSubComponent();
    Log.d(TAG, "userSubComponent is null? " + String.valueOf(userSubComponent == null));

  }
}
