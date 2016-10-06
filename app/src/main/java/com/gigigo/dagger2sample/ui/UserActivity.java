package com.gigigo.dagger2sample.ui;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.gigigo.dagger2sample.BaseActivity;
import com.gigigo.dagger2sample.R;
import com.gigigo.dagger2sample.data.entities.User;
import com.gigigo.dagger2sample.data.preferences.UserPreferencesManager;
import com.gigigo.dagger2sample.di.components.UserSubComponent;
import javax.inject.Inject;

/**
 * Created by santiago.berrocoso on 05/10/16.
 */
public class UserActivity extends BaseActivity implements View.OnClickListener {

  @Inject UserPreferencesManager userPreferencesManager;

  @BindView(R.id.text_title_title) TextView textTitle;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.user_activity);
    ButterKnife.bind(this);

    User user = (User) getIntent().getSerializableExtra("user");
    if (user != null) {
      UserSubComponent userSubComponent = getApp().createUserSubComponent(user);
      userSubComponent.inject(UserActivity.this);

      textTitle.setText(userPreferencesManager.getHelloMessage());
    }else{
      Toast.makeText(UserActivity.this, getString(R.string.error_user_not_login), Toast.LENGTH_LONG).show();
      finish();
    }
  }

  @OnClick(R.id.button_logout)
  @Override public void onClick(View v) {
    getApp().releaseUserComponent();
    finish();
  }

  @Override protected void onResume() {
    super.onResume();

    textTitle.setText( userPreferencesManager.getHelloMessage());
  }
}
