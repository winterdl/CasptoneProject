package com.vpaliy.data.mapper;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MiniUserMapper_Factory implements Factory<MiniUserMapper> {
  private final MembersInjector<MiniUserMapper> miniUserMapperMembersInjector;

  public MiniUserMapper_Factory(MembersInjector<MiniUserMapper> miniUserMapperMembersInjector) {
    assert miniUserMapperMembersInjector != null;
    this.miniUserMapperMembersInjector = miniUserMapperMembersInjector;
  }

  @Override
  public MiniUserMapper get() {
    return MembersInjectors.injectMembers(miniUserMapperMembersInjector, new MiniUserMapper());
  }

  public static Factory<MiniUserMapper> create(
      MembersInjector<MiniUserMapper> miniUserMapperMembersInjector) {
    return new MiniUserMapper_Factory(miniUserMapperMembersInjector);
  }
}
