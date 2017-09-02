package com.vpaliy.data.mapper;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserMapper_Factory implements Factory<UserMapper> {
  private final MembersInjector<UserMapper> userMapperMembersInjector;

  public UserMapper_Factory(MembersInjector<UserMapper> userMapperMembersInjector) {
    assert userMapperMembersInjector != null;
    this.userMapperMembersInjector = userMapperMembersInjector;
  }

  @Override
  public UserMapper get() {
    return MembersInjectors.injectMembers(userMapperMembersInjector, new UserMapper());
  }

  public static Factory<UserMapper> create(MembersInjector<UserMapper> userMapperMembersInjector) {
    return new UserMapper_Factory(userMapperMembersInjector);
  }
}
