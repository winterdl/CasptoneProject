package com.vpaliy.data.source;

import com.vpaliy.soundcloud.SoundCloudService;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PersonalInfo_Factory implements Factory<PersonalInfo> {
  private final Provider<SoundCloudService> serviceProvider;

  public PersonalInfo_Factory(Provider<SoundCloudService> serviceProvider) {
    assert serviceProvider != null;
    this.serviceProvider = serviceProvider;
  }

  @Override
  public PersonalInfo get() {
    return new PersonalInfo(serviceProvider.get());
  }

  public static Factory<PersonalInfo> create(Provider<SoundCloudService> serviceProvider) {
    return new PersonalInfo_Factory(serviceProvider);
  }
}
