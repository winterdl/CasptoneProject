package com.vpaliy.data.source.local.handler;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TrackHandler_Factory implements Factory<TrackHandler> {
  private final Provider<Context> contextProvider;

  public TrackHandler_Factory(Provider<Context> contextProvider) {
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public TrackHandler get() {
    return new TrackHandler(contextProvider.get());
  }

  public static Factory<TrackHandler> create(Provider<Context> contextProvider) {
    return new TrackHandler_Factory(contextProvider);
  }
}
