package com.gigigo.dagger2sample.di.modules;

import android.content.Context;
import com.gigigo.dagger2sample.app.ui.adapters.SearchResultsAdapter;
import com.gigigo.dagger2sample.app.ui.presenters.ArtistSearchPresenter;
import com.gigigo.dagger2sample.app.ui.viewmodel.ArtistSearchView;
import com.gigigo.dagger2sample.domain.interactors.ArtistSearchInteractor;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by santiago.berrocoso on 07/10/16.
 */
@Module public class ArtistSearchModule {

  private final ArtistSearchView artistView;

  public ArtistSearchModule(ArtistSearchView view) {
    this.artistView = view;
  }

  @Provides ArtistSearchView provideView() {
    return artistView;
  }

  @Provides  ArtistSearchPresenter provideArtistPresenter(ArtistSearchView view,
      ArtistSearchInteractor interactor) {
    return new ArtistSearchPresenter(view, interactor);
  }

  @Provides SearchResultsAdapter provideSearchResultAdapter(Context context) {
    return new SearchResultsAdapter(context);
  }
}
