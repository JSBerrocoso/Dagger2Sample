package com.gigigo.dagger2sample.data.api.services;

import com.gigigo.dagger2sample.data.entities.ArtistSearchResponse;
import com.gigigo.dagger2sample.domain.constants.SpotifyApiConstants;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

/**
 * All methods that will make a request to Spotify API
 */
public interface SpotifyApiService {

  @GET(SpotifyApiConstants.ARTIST_SEARCH_URL)
  Observable<ArtistSearchResponse> searchArtist(@Query(SpotifyApiConstants.QUERY_TO_SEARCH) String query);
}
