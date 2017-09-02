package com.vpaliy.data.source.local.handler;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PlaylistHandler_Factory implements Factory<PlaylistHandler> {
  private final Provider<Context> contextProvider;

  public PlaylistHandler_Factory(Provider<Context> contextProvider) {
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public PlaylistHandler get() {
    return new PlaylistHandler(contextProvider.get());
  }

  public static Factory<PlaylistHandler> create(Provider<Context> contextProvider) {
    return new PlaylistHandler_Factory(contextProvider);
  }
}
