package com.vpaliy.domain.loader;

import android.content.Context;
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

  private final Provider<Context> contextProvider;

  private final Provider<PersonalRepository> repositoryProvider;

  public PlaylistHistory_Factory(
      MembersInjector<PlaylistHistory> playlistHistoryMembersInjector,
      Provider<Context> contextProvider,
      Provider<PersonalRepository> repositoryProvider) {
    assert playlistHistoryMembersInjector != null;
    this.playlistHistoryMembersInjector = playlistHistoryMembersInjector;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
    assert repositoryProvider != null;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public PlaylistHistory get() {
    return MembersInjectors.injectMembers(
        playlistHistoryMembersInjector,
        new PlaylistHistory(contextProvider.get(), repositoryProvider.get()));
  }

  public static Factory<PlaylistHistory> create(
      MembersInjector<PlaylistHistory> playlistHistoryMembersInjector,
      Provider<Context> contextProvider,
      Provider<PersonalRepository> repositoryProvider) {
    return new PlaylistHistory_Factory(
        playlistHistoryMembersInjector, contextProvider, repositoryProvider);
  }
}
