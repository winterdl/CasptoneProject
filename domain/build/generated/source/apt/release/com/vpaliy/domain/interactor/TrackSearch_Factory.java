package com.vpaliy.domain.interactor;

import com.vpaliy.domain.executor.BaseSchedulerProvider;
import com.vpaliy.domain.repository.SearchRepository;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TrackSearch_Factory implements Factory<TrackSearch> {
  private final MembersInjector<TrackSearch> trackSearchMembersInjector;

  private final Provider<BaseSchedulerProvider> schedulerProvider;

  private final Provider<SearchRepository> searchRepositoryProvider;

  public TrackSearch_Factory(
      MembersInjector<TrackSearch> trackSearchMembersInjector,
      Provider<BaseSchedulerProvider> schedulerProvider,
      Provider<SearchRepository> searchRepositoryProvider) {
    assert trackSearchMembersInjector != null;
    this.trackSearchMembersInjector = trackSearchMembersInjector;
    assert schedulerProvider != null;
    this.schedulerProvider = schedulerProvider;
    assert searchRepositoryProvider != null;
    this.searchRepositoryProvider = searchRepositoryProvider;
  }

  @Override
  public TrackSearch get() {
    return MembersInjectors.injectMembers(
        trackSearchMembersInjector,
        new TrackSearch(schedulerProvider.get(), searchRepositoryProvider.get()));
  }

  public static Factory<TrackSearch> create(
      MembersInjector<TrackSearch> trackSearchMembersInjector,
      Provider<BaseSchedulerProvider> schedulerProvider,
      Provider<SearchRepository> searchRepositoryProvider) {
    return new TrackSearch_Factory(
        trackSearchMembersInjector, schedulerProvider, searchRepositoryProvider);
  }
}
