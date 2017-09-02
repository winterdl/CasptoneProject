package com.vpaliy.data.source.remote;

import com.vpaliy.data.source.Filter;
import com.vpaliy.soundcloud.SoundCloudService;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RemoteSearchSource_Factory implements Factory<RemoteSearchSource> {
  private final Provider<SoundCloudService> soundCloudServiceProvider;

  private final Provider<Filter> filterProvider;

  public RemoteSearchSource_Factory(
      Provider<SoundCloudService> soundCloudServiceProvider, Provider<Filter> filterProvider) {
    assert soundCloudServiceProvider != null;
    this.soundCloudServiceProvider = soundCloudServiceProvider;
    assert filterProvider != null;
    this.filterProvider = filterProvider;
  }

  @Override
  public RemoteSearchSource get() {
    return new RemoteSearchSource(soundCloudServiceProvider.get(), filterProvider.get());
  }

  public static Factory<RemoteSearchSource> create(
      Provider<SoundCloudService> soundCloudServiceProvider, Provider<Filter> filterProvider) {
    return new RemoteSearchSource_Factory(soundCloudServiceProvider, filterProvider);
  }
}
