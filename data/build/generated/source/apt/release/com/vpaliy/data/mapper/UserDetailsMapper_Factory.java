package com.vpaliy.data.mapper;

import com.vpaliy.domain.model.Playlist;
import com.vpaliy.domain.model.Track;
import com.vpaliy.domain.model.User;
import com.vpaliy.domain.model.WebProfile;
import com.vpaliy.soundcloud.model.PlaylistEntity;
import com.vpaliy.soundcloud.model.TrackEntity;
import com.vpaliy.soundcloud.model.UserEntity;
import com.vpaliy.soundcloud.model.WebProfileEntity;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserDetailsMapper_Factory implements Factory<UserDetailsMapper> {
  private final MembersInjector<UserDetailsMapper> userDetailsMapperMembersInjector;

  private final Provider<Mapper<Track, TrackEntity>> trackMapperProvider;

  private final Provider<Mapper<Playlist, PlaylistEntity>> playlistMapperProvider;

  private final Provider<Mapper<User, UserEntity>> userMapperProvider;

  private final Provider<Mapper<WebProfile, WebProfileEntity>> webMapperProvider;

  public UserDetailsMapper_Factory(
      MembersInjector<UserDetailsMapper> userDetailsMapperMembersInjector,
      Provider<Mapper<Track, TrackEntity>> trackMapperProvider,
      Provider<Mapper<Playlist, PlaylistEntity>> playlistMapperProvider,
      Provider<Mapper<User, UserEntity>> userMapperProvider,
      Provider<Mapper<WebProfile, WebProfileEntity>> webMapperProvider) {
    assert userDetailsMapperMembersInjector != null;
    this.userDetailsMapperMembersInjector = userDetailsMapperMembersInjector;
    assert trackMapperProvider != null;
    this.trackMapperProvider = trackMapperProvider;
    assert playlistMapperProvider != null;
    this.playlistMapperProvider = playlistMapperProvider;
    assert userMapperProvider != null;
    this.userMapperProvider = userMapperProvider;
    assert webMapperProvider != null;
    this.webMapperProvider = webMapperProvider;
  }

  @Override
  public UserDetailsMapper get() {
    return MembersInjectors.injectMembers(
        userDetailsMapperMembersInjector,
        new UserDetailsMapper(
            trackMapperProvider.get(),
            playlistMapperProvider.get(),
            userMapperProvider.get(),
            webMapperProvider.get()));
  }

  public static Factory<UserDetailsMapper> create(
      MembersInjector<UserDetailsMapper> userDetailsMapperMembersInjector,
      Provider<Mapper<Track, TrackEntity>> trackMapperProvider,
      Provider<Mapper<Playlist, PlaylistEntity>> playlistMapperProvider,
      Provider<Mapper<User, UserEntity>> userMapperProvider,
      Provider<Mapper<WebProfile, WebProfileEntity>> webMapperProvider) {
    return new UserDetailsMapper_Factory(
        userDetailsMapperMembersInjector,
        trackMapperProvider,
        playlistMapperProvider,
        userMapperProvider,
        webMapperProvider);
  }
}
