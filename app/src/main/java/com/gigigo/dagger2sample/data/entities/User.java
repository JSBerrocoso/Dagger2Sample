package com.gigigo.dagger2sample.data.entities;

import java.io.Serializable;

/**
 * Created by santiago.berrocoso on 05/10/16.
 */

public class User implements Serializable {

  private final String name;

  public User(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
