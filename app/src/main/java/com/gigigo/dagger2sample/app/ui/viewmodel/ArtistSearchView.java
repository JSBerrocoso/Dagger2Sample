package com.gigigo.dagger2sample.app.ui.viewmodel;

import com.gigigo.dagger2sample.app.ui.views.activities.ArtistSearchActivity;
import com.gigigo.dagger2sample.domain.entities.Artist;
import java.util.ArrayList;

/**
 * Created by santiago.berrocoso on 13/06/2015.
 *
 * <p>
 * Model for every UI operations that could occur in {@link ArtistSearchActivity}
 * </p>
 */
public interface ArtistSearchView {

  void setupList();

  void setupAdapter();

  void displayFoundArtists(ArrayList<Artist> artists);

  void displayFailedSearch();

  void displayNetworkError();

  void displayServerError();
}
