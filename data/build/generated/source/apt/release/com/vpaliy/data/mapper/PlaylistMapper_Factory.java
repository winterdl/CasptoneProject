package com.vpaliy.data.mapper;

import android.content.Context;
import com.vpaliy.domain.model.Track;
import com.vpaliy.domain.model.User;
import com.vpaliy.soundcloud.model.MiniUserEntity;
import com.vpaliy.soundcloud.model.TrackEntity;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PlaylistMapper_Factory implements Factory<PlaylistMapper> {
  private final MembersInjector<PlaylistMapper> playlistMapperMembersInjector;

  private final Provider<Mapper<Track, TrackEntity>> trackMapperProvider;

  private final Provider<Mapper<User, MiniUserEntity>> userMapperProvider;

  private final Provider<Context> contextProvider;

  public PlaylistMapper_Factory(
      MembersInjector<PlaylistMapper> playlistMapperMembersInjector,
      Provider<Mapper<Track, TrackEntity>> trackMapperProvider,
      Provider<Mapper<User, MiniUserEntity>> userMapperProvider,
      Provider<Context> contextProvider) {
    assert playlistMapperMembersInjector != null;
    this.playlistMapperMembersInjector = playlistMapperMembersInjector;
    assert trackMapperProvider != null;
    this.trackMapperProvider = trackMapperProvider;
    assert userMapperProvider != null;
    this.userMapperProvider = userMapperProvider;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public PlaylistMapper get() {
    return MembersInjectors.injectMembers(
        playlistMapperMembersInjector,
        new PlaylistMapper(
            trackMapperProvider.get(), userMapperProvider.get(), contextProvider.get()));
  }

  public static Factory<PlaylistMapper> create(
      MembersInjector<PlaylistMapper> playlistMapperMembersInjector,
      Provider<Mapper<Track, TrackEntity>> trackMapperProvider,
      Provider<Mapper<User, MiniUserEntity>> userMapperProvider,
      Provider<Context> contextProvider) {
    return new PlaylistMapper_Factory(
        playlistMapperMembersInjector, trackMapperProvider, userMapperProvider, contextProvider);
  }
}
