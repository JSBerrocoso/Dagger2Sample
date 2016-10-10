package com.gigigo.dagger2sample.domain.callbacks;

import com.gigigo.dagger2sample.domain.entities.Artist;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by santiago.berrocoso on 07/10/16.
 */
public interface ArtistSearchServerCallback extends ServerCallback {

  void onArtistFound(ArrayList<Artist> results);

  void onFailedSearch();
}
