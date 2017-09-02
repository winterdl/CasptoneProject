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
public final class GetPlaylists_Factory implements Factory<GetPlaylists> {
  private final MembersInjector<GetPlaylists> getPlaylistsMembersInjector;

  private final Provider<Context> contextProvider;

  private final Provider<Repository> repositoryProvider;

  public GetPlaylists_Factory(
      MembersInjector<GetPlaylists> getPlaylistsMembersInjector,
      Provider<Context> contextProvider,
      Provider<Repository> repositoryProvider) {
    assert getPlaylistsMembersInjector != null;
    this.getPlaylistsMembersInjector = getPlaylistsMembersInjector;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
    assert repositoryProvider != null;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetPlaylists get() {
    return MembersInjectors.injectMembers(
        getPlaylistsMembersInjector,
        new GetPlaylists(contextProvider.get(), repositoryProvider.get()));
  }

  public static Factory<GetPlaylists> create(
      MembersInjector<GetPlaylists> getPlaylistsMembersInjector,
      Provider<Context> contextProvider,
      Provider<Repository> repositoryProvider) {
    return new GetPlaylists_Factory(
        getPlaylistsMembersInjector, contextProvider, repositoryProvider);
  }
}
