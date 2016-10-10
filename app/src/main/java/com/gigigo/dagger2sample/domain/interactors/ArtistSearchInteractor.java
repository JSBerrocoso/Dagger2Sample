package com.gigigo.dagger2sample.domain.interactors;

import com.gigigo.dagger2sample.data.api.services.SpotifyApiService;
import com.gigigo.dagger2sample.domain.callbacks.ArtistSearchServerCallback;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by santiago.berrocoso on 06/10/16.
 */
public class ArtistSearchInteractor {

  public static final String TAG = ArtistSearchInteractor.class.getSimpleName();

  SpotifyApiService spotifyApiService;

  public ArtistSearchInteractor(SpotifyApiService spotifyApiService) {
    this.spotifyApiService = spotifyApiService;
  }

  public void performSearch(String text, ArtistSearchServerCallback callback) {

    spotifyApiService.searchArtist(text)
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(artistSearchResponse -> {
          callback.onArtistFound(artistSearchResponse.getArtists());
        }, throwable -> {
          callback.onFailedSearch();
        });
  }
}

