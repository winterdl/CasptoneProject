package com.vpaliy.data.repository;

import com.vpaliy.data.mapper.Mapper;
import com.vpaliy.data.source.Filter;
import com.vpaliy.data.source.PersonalInfo;
import com.vpaliy.data.source.local.handler.PlaylistHandler;
import com.vpaliy.data.source.local.handler.TrackHandler;
import com.vpaliy.domain.model.User;
import com.vpaliy.soundcloud.SoundCloudService;
import com.vpaliy.soundcloud.model.UserEntity;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MusicPersonalRepository_Factory implements Factory<MusicPersonalRepository> {
  private final Provider<SoundCloudService> serviceProvider;

  private final Provider<Mapper<User, UserEntity>> userMapperProvider;

  private final Provider<PlaylistHandler> playlistHandlerProvider;

  private final Provider<TrackHandler> trackHandlerProvider;

  private final Provider<Filter> filterProvider;

  private final Provider<PersonalInfo> personalInfoProvider;

  public MusicPersonalRepository_Factory(
      Provider<SoundCloudService> serviceProvider,
      Provider<Mapper<User, UserEntity>> userMapperProvider,
      Provider<PlaylistHandler> playlistHandlerProvider,
      Provider<TrackHandler> trackHandlerProvider,
      Provider<Filter> filterProvider,
      Provider<PersonalInfo> personalInfoProvider) {
    assert serviceProvider != null;
    this.serviceProvider = serviceProvider;
    assert userMapperProvider != null;
    this.userMapperProvider = userMapperProvider;
    assert playlistHandlerProvider != null;
    this.playlistHandlerProvider = playlistHandlerProvider;
    assert trackHandlerProvider != null;
    this.trackHandlerProvider = trackHandlerProvider;
    assert filterProvider != null;
    this.filterProvider = filterProvider;
    assert personalInfoProvider != null;
    this.personalInfoProvider = personalInfoProvider;
  }

  @Override
  public MusicPersonalRepository get() {
    return new MusicPersonalRepository(
        serviceProvider.get(),
        userMapperProvider.get(),
        playlistHandlerProvider.get(),
        trackHandlerProvider.get(),
        filterProvider.get(),
        personalInfoProvider.get());
  }

  public static Factory<MusicPersonalRepository> create(
      Provider<SoundCloudService> serviceProvider,
      Provider<Mapper<User, UserEntity>> userMapperProvider,
      Provider<PlaylistHandler> playlistHandlerProvider,
      Provider<TrackHandler> trackHandlerProvider,
      Provider<Filter> filterProvider,
      Provider<PersonalInfo> personalInfoProvider) {
    return new MusicPersonalRepository_Factory(
        serviceProvider,
        userMapperProvider,
        playlistHandlerProvider,
        trackHandlerProvider,
        filterProvider,
        personalInfoProvider);
  }
}
