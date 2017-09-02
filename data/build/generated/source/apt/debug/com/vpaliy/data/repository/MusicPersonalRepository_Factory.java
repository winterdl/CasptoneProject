package com.vpaliy.data.repository;

import com.vpaliy.data.mapper.Mapper;
import com.vpaliy.data.source.PersonalInfo;
import com.vpaliy.data.source.Filter;
import com.vpaliy.domain.model.Playlist;
import com.vpaliy.domain.model.Track;
import com.vpaliy.domain.model.User;
import com.vpaliy.soundcloud.SoundCloudService;
import com.vpaliy.soundcloud.model.PlaylistEntity;
import com.vpaliy.soundcloud.model.TrackEntity;
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

  private final Provider<Mapper<Playlist, PlaylistEntity>> playlistMapperProvider;

  private final Provider<Mapper<Track, TrackEntity>> trackMapperProvider;

  private final Provider<PersonalInfo> personalInfoProvider;

  private final Provider<Filter> filterProvider;

  public MusicPersonalRepository_Factory(
      Provider<SoundCloudService> serviceProvider,
      Provider<Mapper<User, UserEntity>> userMapperProvider,
      Provider<Mapper<Playlist, PlaylistEntity>> playlistMapperProvider,
      Provider<Mapper<Track, TrackEntity>> trackMapperProvider,
      Provider<PersonalInfo> personalInfoProvider,
      Provider<Filter> filterProvider) {
    assert serviceProvider != null;
    this.serviceProvider = serviceProvider;
    assert userMapperProvider != null;
    this.userMapperProvider = userMapperProvider;
    assert playlistMapperProvider != null;
    this.playlistMapperProvider = playlistMapperProvider;
    assert trackMapperProvider != null;
    this.trackMapperProvider = trackMapperProvider;
    assert personalInfoProvider != null;
    this.personalInfoProvider = personalInfoProvider;
    assert filterProvider != null;
    this.filterProvider = filterProvider;
  }

  @Override
  public MusicPersonalRepository get() {
    return new MusicPersonalRepository(
        serviceProvider.get(),
        userMapperProvider.get(),
        playlistMapperProvider.get(),
        trackMapperProvider.get(),
        personalInfoProvider.get(),
        filterProvider.get());
  }

  public static Factory<MusicPersonalRepository> create(
      Provider<SoundCloudService> serviceProvider,
      Provider<Mapper<User, UserEntity>> userMapperProvider,
      Provider<Mapper<Playlist, PlaylistEntity>> playlistMapperProvider,
      Provider<Mapper<Track, TrackEntity>> trackMapperProvider,
      Provider<PersonalInfo> personalInfoProvider,
      Provider<Filter> filterProvider) {
    return new MusicPersonalRepository_Factory(
        serviceProvider,
        userMapperProvider,
        playlistMapperProvider,
        trackMapperProvider,
        personalInfoProvider,
        filterProvider);
  }
}
