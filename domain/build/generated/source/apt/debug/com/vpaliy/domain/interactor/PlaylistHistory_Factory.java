package com.vpaliy.domain.interactor;

import com.vpaliy.domain.executor.BaseSchedulerProvider;
import com.vpaliy.domain.repository.PersonalRepository;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PlaylistHistory_Factory implements Factory<PlaylistHistory> {
  private final MembersInjector<PlaylistHistory> playlistHistoryMembersInjector;

  private final Provider<BaseSchedulerProvider> schedulerProvider;

  private final Provider<PersonalRepository> repositoryProvider;

  public PlaylistHistory_Factory(
      MembersInjector<PlaylistHistory> playlistHistoryMembersInjector,
      Provider<BaseSchedulerProvider> schedulerProvider,
      Provider<PersonalRepository> repositoryProvider) {
    assert playlistHistoryMembersInjector != null;
    this.playlistHistoryMembersInjector = playlistHistoryMembersInjector;
    assert schedulerProvider != null;
    this.schedulerProvider = schedulerProvider;
    assert repositoryProvider != null;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public PlaylistHistory get() {
    return MembersInjectors.injectMembers(
        playlistHistoryMembersInjector,
        new PlaylistHistory(schedulerProvider.get(), repositoryProvider.get()));
  }

  public static Factory<PlaylistHistory> create(
      MembersInjector<PlaylistHistory> playlistHistoryMembersInjector,
      Provider<BaseSchedulerProvider> schedulerProvider,
      Provider<PersonalRepository> repositoryProvider) {
    return new PlaylistHistory_Factory(
        playlistHistoryMembersInjector, schedulerProvider, repositoryProvider);
  }
}
