package com.gigigo.dagger2sample.di.components;

import com.gigigo.dagger2sample.app.ui.adapters.SearchResultsAdapter;
import com.gigigo.dagger2sample.app.ui.presenters.ArtistSearchPresenter;
import com.gigigo.dagger2sample.app.ui.views.activities.ArtistSearchActivity;
import com.gigigo.dagger2sample.app.ui.views.fragment.ArtistSearchFragment;
import com.gigigo.dagger2sample.di.modules.ArtistSearchModule;
import com.gigigo.dagger2sample.di.scopes.ActivityScope;
import dagger.Component;

/**
 * Created by santiago.berrocoso on 07/10/16.
 *
 * Methods to inject dependencies into {@link ArtistSearchActivity}
 */
@ActivityScope
@Component(
    dependencies = ApplicationComponent.class,
    modules = ArtistSearchModule.class)
public interface ArtistsSearchComponent {

  void inject(ArtistSearchFragment artistSearchFragment);

  ArtistSearchPresenter getArtistPresenter();

  SearchResultsAdapter getAdapter();


}
