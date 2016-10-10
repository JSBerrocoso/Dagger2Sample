package com.gigigo.dagger2sample.di.modules;

import com.gigigo.dagger2sample.data.api.services.SpotifyApiService;
import com.gigigo.dagger2sample.domain.interactors.ArtistSearchInteractor;
import dagger.Module;
import dagger.Provides;

/**
 * Created by santiago.berrocoso on 06/10/16.
 *
 * Create all interactors
 */

@Module public class InteractorModule {

  @Provides ArtistSearchInteractor provideArtistSearchInteractor(SpotifyApiService apiService) {
    return new ArtistSearchInteractor(apiService);
  }
}
