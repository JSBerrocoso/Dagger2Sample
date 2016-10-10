package com.gigigo.dagger2sample.domain.entities;

import android.support.annotation.Nullable;
import com.gigigo.dagger2sample.domain.constants.Constants;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;

/**
 * Created by santiago.berrocoso on 06/10/16.
 */
public class Artist {
  String name;

  @SerializedName(Constants.IMAGES) @Nullable SpotifyImage[] urlImage;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SpotifyImage[] getUrlsImage() {
    return urlImage;
  }

  public void setUrlsImage(SpotifyImage[] urlImage) {
    this.urlImage = urlImage;
  }

  @Nullable public SpotifyImage getMediumImage() {
    assert urlImage != null;
    if (urlImage.length >= 2) {
      return urlImage[1];
    }

    return null;
  }

  @Override public String toString() {
    return "Artist{" +
        "name='" + name + '\'' +
        ", urlImage='" + Arrays.toString(urlImage) + '\'' +
        '}';
  }
}
