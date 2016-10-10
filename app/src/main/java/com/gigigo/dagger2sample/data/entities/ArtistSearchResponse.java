package com.gigigo.dagger2sample.data.entities;

import com.gigigo.dagger2sample.domain.entities.Artist;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/**
 * Created by santiago.berrocoso
 * A simple model to parse with {@link com.google.gson.Gson}
 */
public class ArtistSearchResponse {

  @SerializedName("artists")
  ArtistsResponse artistsResponse;

  public ArrayList<Artist> getArtists() {
    return artistsResponse.artists;
  }

  private class ArtistsResponse {
    @SerializedName("items")
    ArrayList<Artist> artists;
  }
}
