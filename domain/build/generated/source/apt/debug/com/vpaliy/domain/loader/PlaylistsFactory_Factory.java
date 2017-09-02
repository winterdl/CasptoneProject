package com.vpaliy.domain.loader;

import android.content.Context;
import com.vpaliy.domain.repository.Repository;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PlaylistsFactory_Factory implements Factory<PlaylistsFactory> {
  private final MembersInjector<PlaylistsFactory> playlistsFactoryMembersInjector;

  private final Provider<Context> contextProvider;

  private final Provider<Repository> repositoryProvider;

  public PlaylistsFactory_Factory(
      MembersInjector<PlaylistsFactory> playlistsFactoryMembersInjector,
      Provider<Context> contextProvider,
      Provider<Repository> repositoryProvider) {
    assert playlistsFactoryMembersInjector != null;
    this.playlistsFactoryMembersInjector = playlistsFactoryMembersInjector;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
    assert repositoryProvider != null;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public PlaylistsFactory get() {
    return MembersInjectors.injectMembers(
        playlistsFactoryMembersInjector,
        new PlaylistsFactory(contextProvider.get(), repositoryProvider.get()));
  }

  public static Factory<PlaylistsFactory> create(
      MembersInjector<PlaylistsFactory> playlistsFactoryMembersInjector,
      Provider<Context> contextProvider,
      Provider<Repository> repositoryProvider) {
    return new PlaylistsFactory_Factory(
        playlistsFactoryMembersInjector, contextProvider, repositoryProvider);
  }
}
