package com.vpaliy.data.repository;

import android.content.Context;
import com.vpaliy.data.mapper.Mapper;
import com.vpaliy.data.model.UserDetailsEntity;
import com.vpaliy.data.source.LocalSource;
import com.vpaliy.data.source.PersonalInfo;
import com.vpaliy.data.source.RemoteSource;
import com.vpaliy.domain.executor.BaseSchedulerProvider;
import com.vpaliy.domain.model.Playlist;
import com.vpaliy.domain.model.Track;
import com.vpaliy.domain.model.User;
import com.vpaliy.domain.model.UserDetails;
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
public final class MusicRepository_Factory implements Factory<MusicRepository> {
  private final Provider<Mapper<Playlist, PlaylistEntity>> playlistMapperProvider;

  private final Provider<Mapper<Track, TrackEntity>> trackMapperProvider;

  private final Provider<Mapper<User, UserEntity>> userMapperProvider;

  private final Provider<Mapper<UserDetails, UserDetailsEntity>> detailsMapperProvider;

  private final Provider<RemoteSource> remoteSourceProvider;

  private final Provider<LocalSource> localSourceProvider;

  private final Provider<PersonalInfo> personalInfoProvider;

  private final Provider<Context> contextProvider;

  private final Provider<BaseSchedulerProvider> schedulerProvider;

  public MusicRepository_Factory(
      Provider<Mapper<Playlist, PlaylistEntity>> playlistMapperProvider,
      Provider<Mapper<Track, TrackEntity>> trackMapperProvider,
      Provider<Mapper<User, UserEntity>> userMapperProvider,
      Provider<Mapper<UserDetails, UserDetailsEntity>> detailsMapperProvider,
      Provider<RemoteSource> remoteSourceProvider,
      Provider<LocalSource> localSourceProvider,
      Provider<PersonalInfo> personalInfoProvider,
      Provider<Context> contextProvider,
      Provider<BaseSchedulerProvider> schedulerProvider) {
    assert playlistMapperProvider != null;
    this.playlistMapperProvider = playlistMapperProvider;
    assert trackMapperProvider != null;
    this.trackMapperProvider = trackMapperProvider;
    assert userMapperProvider != null;
    this.userMapperProvider = userMapperProvider;
    assert detailsMapperProvider != null;
    this.detailsMapperProvider = detailsMapperProvider;
    assert remoteSourceProvider != null;
    this.remoteSourceProvider = remoteSourceProvider;
    assert localSourceProvider != null;
    this.localSourceProvider = localSourceProvider;
    assert personalInfoProvider != null;
    this.personalInfoProvider = personalInfoProvider;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
    assert schedulerProvider != null;
    this.schedulerProvider = schedulerProvider;
  }

  @Override
  public MusicRepository get() {
    return new MusicRepository(
        playlistMapperProvider.get(),
        trackMapperProvider.get(),
        userMapperProvider.get(),
        detailsMapperProvider.get(),
        remoteSourceProvider.get(),
        localSourceProvider.get(),
        personalInfoProvider.get(),
        contextProvider.get(),
        schedulerProvider.get());
  }

  public static Factory<MusicRepository> create(
      Provider<Mapper<Playlist, PlaylistEntity>> playlistMapperProvider,
      Provider<Mapper<Track, TrackEntity>> trackMapperProvider,
      Provider<Mapper<User, UserEntity>> userMapperProvider,
      Provider<Mapper<UserDetails, UserDetailsEntity>> detailsMapperProvider,
      Provider<RemoteSource> remoteSourceProvider,
      Provider<LocalSource> localSourceProvider,
      Provider<PersonalInfo> personalInfoProvider,
      Provider<Context> contextProvider,
      Provider<BaseSchedulerProvider> schedulerProvider) {
    return new MusicRepository_Factory(
        playlistMapperProvider,
        trackMapperProvider,
        userMapperProvider,
        detailsMapperProvider,
        remoteSourceProvider,
        localSourceProvider,
        personalInfoProvider,
        contextProvider,
        schedulerProvider);
  }
}
