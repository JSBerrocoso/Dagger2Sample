package com.gigigo.dagger2sample.domain.entities;

import com.gigigo.dagger2sample.domain.constants.Constants;
import com.google.gson.annotations.SerializedName;

/**
 * Created by santiago.berrocoso on 17/06/2015.
 */
public class SpotifyImage {

  @SerializedName(Constants.WIDTH) int width;

  @SerializedName(Constants.HEIGHT) int height;

  @SerializedName(Constants.URL) String url;

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override public String toString() {
    return "SpotifyImage{" +
        "width=" + width +
        ", height=" + height +
        ", url='" + url + '\'' +
        '}';
  }
}
