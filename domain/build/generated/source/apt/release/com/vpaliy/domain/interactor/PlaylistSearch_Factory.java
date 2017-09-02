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
public final class PlaylistSearch_Factory implements Factory<PlaylistSearch> {
  private final MembersInjector<PlaylistSearch> playlistSearchMembersInjector;

  private final Provider<BaseSchedulerProvider> schedulerProvider;

  private final Provider<SearchRepository> searchRepositoryProvider;

  public PlaylistSearch_Factory(
      MembersInjector<PlaylistSearch> playlistSearchMembersInjector,
      Provider<BaseSchedulerProvider> schedulerProvider,
      Provider<SearchRepository> searchRepositoryProvider) {
    assert playlistSearchMembersInjector != null;
    this.playlistSearchMembersInjector = playlistSearchMembersInjector;
    assert schedulerProvider != null;
    this.schedulerProvider = schedulerProvider;
    assert searchRepositoryProvider != null;
    this.searchRepositoryProvider = searchRepositoryProvider;
  }

  @Override
  public PlaylistSearch get() {
    return MembersInjectors.injectMembers(
        playlistSearchMembersInjector,
        new PlaylistSearch(schedulerProvider.get(), searchRepositoryProvider.get()));
  }

  public static Factory<PlaylistSearch> create(
      MembersInjector<PlaylistSearch> playlistSearchMembersInjector,
      Provider<BaseSchedulerProvider> schedulerProvider,
      Provider<SearchRepository> searchRepositoryProvider) {
    return new PlaylistSearch_Factory(
        playlistSearchMembersInjector, schedulerProvider, searchRepositoryProvider);
  }
}
