package com.vpaliy.data.source;

import android.content.Context;
import com.vpaliy.data.mapper.Mapper;
import com.vpaliy.data.source.local.handler.TrackHandler;
import com.vpaliy.data.source.local.handler.UserHandler;
import com.vpaliy.domain.model.Track;
import com.vpaliy.domain.model.User;
import com.vpaliy.soundcloud.SoundCloudService;
import com.vpaliy.soundcloud.model.TrackEntity;
import com.vpaliy.soundcloud.model.UserEntity;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PersonalInfo_Factory implements Factory<PersonalInfo> {
  private final Provider<Context> contextProvider;

  private final Provider<SoundCloudService> serviceProvider;

  private final Provider<Mapper<Track, TrackEntity>> trackMapperProvider;

  private final Provider<Mapper<User, UserEntity>> userMapperProvider;

  private final Provider<TrackHandler> trackHandlerProvider;

  private final Provider<UserHandler> userHandlerProvider;

  public PersonalInfo_Factory(
      Provider<Context> contextProvider,
      Provider<SoundCloudService> serviceProvider,
      Provider<Mapper<Track, TrackEntity>> trackMapperProvider,
      Provider<Mapper<User, UserEntity>> userMapperProvider,
      Provider<TrackHandler> trackHandlerProvider,
      Provider<UserHandler> userHandlerProvider) {
    assert contextProvider != null;
    this.contextProvider = contextProvider;
    assert serviceProvider != null;
    this.serviceProvider = serviceProvider;
    assert trackMapperProvider != null;
    this.trackMapperProvider = trackMapperProvider;
    assert userMapperProvider != null;
    this.userMapperProvider = userMapperProvider;
    assert trackHandlerProvider != null;
    this.trackHandlerProvider = trackHandlerProvider;
    assert userHandlerProvider != null;
    this.userHandlerProvider = userHandlerProvider;
  }

  @Override
  public PersonalInfo get() {
    return new PersonalInfo(
        contextProvider.get(),
        serviceProvider.get(),
        trackMapperProvider.get(),
        userMapperProvider.get(),
        trackHandlerProvider.get(),
        userHandlerProvider.get());
  }

  public static Factory<PersonalInfo> create(
      Provider<Context> contextProvider,
      Provider<SoundCloudService> serviceProvider,
      Provider<Mapper<Track, TrackEntity>> trackMapperProvider,
      Provider<Mapper<User, UserEntity>> userMapperProvider,
      Provider<TrackHandler> trackHandlerProvider,
      Provider<UserHandler> userHandlerProvider) {
    return new PersonalInfo_Factory(
        contextProvider,
        serviceProvider,
        trackMapperProvider,
        userMapperProvider,
        trackHandlerProvider,
        userHandlerProvider);
  }
}
