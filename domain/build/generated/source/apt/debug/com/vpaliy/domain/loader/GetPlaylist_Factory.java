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
public final class GetPlaylist_Factory implements Factory<GetPlaylist> {
  private final MembersInjector<GetPlaylist> getPlaylistMembersInjector;

  private final Provider<Context> contextProvider;

  private final Provider<Repository> repositoryProvider;

  public GetPlaylist_Factory(
      MembersInjector<GetPlaylist> getPlaylistMembersInjector,
      Provider<Context> contextProvider,
      Provider<Repository> repositoryProvider) {
    assert getPlaylistMembersInjector != null;
    this.getPlaylistMembersInjector = getPlaylistMembersInjector;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
    assert repositoryProvider != null;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetPlaylist get() {
    return MembersInjectors.injectMembers(
        getPlaylistMembersInjector,
        new GetPlaylist(contextProvider.get(), repositoryProvider.get()));
  }

  public static Factory<GetPlaylist> create(
      MembersInjector<GetPlaylist> getPlaylistMembersInjector,
      Provider<Context> contextProvider,
      Provider<Repository> repositoryProvider) {
    return new GetPlaylist_Factory(getPlaylistMembersInjector, contextProvider, repositoryProvider);
  }
}
