package com.vpaliy.data.mapper;

import com.vpaliy.domain.model.User;
import com.vpaliy.soundcloud.model.MiniUserEntity;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TrackMapper_Factory implements Factory<TrackMapper> {
  private final MembersInjector<TrackMapper> trackMapperMembersInjector;

  private final Provider<Mapper<User, MiniUserEntity>> userMapperProvider;

  public TrackMapper_Factory(
      MembersInjector<TrackMapper> trackMapperMembersInjector,
      Provider<Mapper<User, MiniUserEntity>> userMapperProvider) {
    assert trackMapperMembersInjector != null;
    this.trackMapperMembersInjector = trackMapperMembersInjector;
    assert userMapperProvider != null;
    this.userMapperProvider = userMapperProvider;
  }

  @Override
  public TrackMapper get() {
    return MembersInjectors.injectMembers(
        trackMapperMembersInjector, new TrackMapper(userMapperProvider.get()));
  }

  public static Factory<TrackMapper> create(
      MembersInjector<TrackMapper> trackMapperMembersInjector,
      Provider<Mapper<User, MiniUserEntity>> userMapperProvider) {
    return new TrackMapper_Factory(trackMapperMembersInjector, userMapperProvider);
  }
}
