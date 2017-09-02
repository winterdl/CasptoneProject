package com.vpaliy.data.mapper;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WebProfileMapper_Factory implements Factory<WebProfileMapper> {
  private final MembersInjector<WebProfileMapper> webProfileMapperMembersInjector;

  public WebProfileMapper_Factory(
      MembersInjector<WebProfileMapper> webProfileMapperMembersInjector) {
    assert webProfileMapperMembersInjector != null;
    this.webProfileMapperMembersInjector = webProfileMapperMembersInjector;
  }

  @Override
  public WebProfileMapper get() {
    return MembersInjectors.injectMembers(webProfileMapperMembersInjector, new WebProfileMapper());
  }

  public static Factory<WebProfileMapper> create(
      MembersInjector<WebProfileMapper> webProfileMapperMembersInjector) {
    return new WebProfileMapper_Factory(webProfileMapperMembersInjector);
  }
}
