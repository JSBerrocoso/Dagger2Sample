package com.gigigo.dagger2sample.app.ui.views.activities;

import android.view.Menu;
import android.view.MenuItem;
import com.gigigo.dagger2sample.R;
import com.gigigo.dagger2sample.app.common.BaseActivity;
import com.gigigo.dagger2sample.di.components.ApplicationComponent;
import com.gigigo.dagger2sample.presentation.presenters.BasePresenter;

/**
 * <p>
 * The main activity, its due is provide a UI that allow the user to
 * issue a search for an artist.
 * </p>
 */
public class ArtistSearchActivity extends BaseActivity {

  @Override protected int getLayout() {
    return R.layout.activity_artist_search;
  }

  @Override protected BasePresenter getPresenter() {
    return null;
  }

  @Override public void setUpComponent(ApplicationComponent appComponent) {
    //There isn't dependencies
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  public boolean onOptionsItemSelected(MenuItem item) {
    return super.onOptionsItemSelected(item);
  }
}
