package com.vpaliy.data.source.local;

import com.vpaliy.data.source.local.handler.PlaylistHandler;
import com.vpaliy.data.source.local.handler.TrackHandler;
import com.vpaliy.data.source.local.handler.UserHandler;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LocalMusicSource_Factory implements Factory<LocalMusicSource> {
  private final Provider<PlaylistHandler> playlistHandlerProvider;

  private final Provider<TrackHandler> trackHandlerProvider;

  private final Provider<UserHandler> userHandlerProvider;

  public LocalMusicSource_Factory(
      Provider<PlaylistHandler> playlistHandlerProvider,
      Provider<TrackHandler> trackHandlerProvider,
      Provider<UserHandler> userHandlerProvider) {
    assert playlistHandlerProvider != null;
    this.playlistHandlerProvider = playlistHandlerProvider;
    assert trackHandlerProvider != null;
    this.trackHandlerProvider = trackHandlerProvider;
    assert userHandlerProvider != null;
    this.userHandlerProvider = userHandlerProvider;
  }

  @Override
  public LocalMusicSource get() {
    return new LocalMusicSource(
        playlistHandlerProvider.get(), trackHandlerProvider.get(), userHandlerProvider.get());
  }

  public static Factory<LocalMusicSource> create(
      Provider<PlaylistHandler> playlistHandlerProvider,
      Provider<TrackHandler> trackHandlerProvider,
      Provider<UserHandler> userHandlerProvider) {
    return new LocalMusicSource_Factory(
        playlistHandlerProvider, trackHandlerProvider, userHandlerProvider);
  }
}
