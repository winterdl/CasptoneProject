package com.vpaliy.data.source.remote;

import com.vpaliy.data.source.Filter;
import com.vpaliy.domain.executor.BaseSchedulerProvider;
import com.vpaliy.soundcloud.SoundCloudService;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MusicRemoteSource_Factory implements Factory<MusicRemoteSource> {
  private final Provider<SoundCloudService> serviceProvider;

  private final Provider<BaseSchedulerProvider> schedulerProvider;

  private final Provider<Filter> filterProvider;

  public MusicRemoteSource_Factory(
      Provider<SoundCloudService> serviceProvider,
      Provider<BaseSchedulerProvider> schedulerProvider,
      Provider<Filter> filterProvider) {
    assert serviceProvider != null;
    this.serviceProvider = serviceProvider;
    assert schedulerProvider != null;
    this.schedulerProvider = schedulerProvider;
    assert filterProvider != null;
    this.filterProvider = filterProvider;
  }

  @Override
  public MusicRemoteSource get() {
    return new MusicRemoteSource(
        serviceProvider.get(), schedulerProvider.get(), filterProvider.get());
  }

  public static Factory<MusicRemoteSource> create(
      Provider<SoundCloudService> serviceProvider,
      Provider<BaseSchedulerProvider> schedulerProvider,
      Provider<Filter> filterProvider) {
    return new MusicRemoteSource_Factory(serviceProvider, schedulerProvider, filterProvider);
  }
}
