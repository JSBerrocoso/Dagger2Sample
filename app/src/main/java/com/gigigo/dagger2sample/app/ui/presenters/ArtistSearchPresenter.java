package com.gigigo.dagger2sample.app.ui.presenters;

import com.gigigo.dagger2sample.app.ui.viewmodel.ArtistSearchView;
import com.gigigo.dagger2sample.domain.callbacks.ArtistSearchServerCallback;
import com.gigigo.dagger2sample.domain.entities.Artist;
import com.gigigo.dagger2sample.domain.interactors.ArtistSearchInteractor;
import com.gigigo.dagger2sample.presentation.presenters.BasePresenter;
import java.util.ArrayList;

/**
 * Created by santiago.berrocoso on 07/10/16.
 */
public class ArtistSearchPresenter extends BasePresenter implements ArtistSearchServerCallback {

  ArtistSearchView view;
  ArtistSearchInteractor searchInteractor;

  public ArtistSearchPresenter(ArtistSearchView view, ArtistSearchInteractor interactor) {
    this.view = view;
    this.searchInteractor = interactor;
  }

  @Override public void onStart() {
    view.setupAdapter();
    view.setupList();
  }

  @Override public void onStop() {

  }

  public void searchArtists(String text) {
    searchInteractor.performSearch(text, this);
  }

  @Override public void onArtistFound(ArrayList<Artist> results) {
    view.displayFoundArtists(results);
  }

  @Override public void onFailedSearch() {
    view.displayFailedSearch();
  }

  @Override public void onNetworkError() {
    view.displayNetworkError();
  }

  @Override public void onServerError() {
    view.displayServerError();
  }
}
