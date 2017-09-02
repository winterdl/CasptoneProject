package com.vpaliy.data.source.remote;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Filter_Factory implements Factory<Filter> {
  private static final Filter_Factory INSTANCE = new Filter_Factory();

  @Override
  public Filter get() {
    return new Filter();
  }

  public static Factory<Filter> create() {
    return INSTANCE;
  }
}
