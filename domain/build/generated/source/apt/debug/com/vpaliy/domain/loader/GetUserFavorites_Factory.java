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
public final class GetUserFavorites_Factory implements Factory<GetUserFavorites> {
  private final MembersInjector<GetUserFavorites> getUserFavoritesMembersInjector;

  private final Provider<Context> contextProvider;

  private final Provider<Repository> repositoryProvider;

  public GetUserFavorites_Factory(
      MembersInjector<GetUserFavorites> getUserFavoritesMembersInjector,
      Provider<Context> contextProvider,
      Provider<Repository> repositoryProvider) {
    assert getUserFavoritesMembersInjector != null;
    this.getUserFavoritesMembersInjector = getUserFavoritesMembersInjector;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
    assert repositoryProvider != null;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetUserFavorites get() {
    return MembersInjectors.injectMembers(
        getUserFavoritesMembersInjector,
        new GetUserFavorites(contextProvider.get(), repositoryProvider.get()));
  }

  public static Factory<GetUserFavorites> create(
      MembersInjector<GetUserFavorites> getUserFavoritesMembersInjector,
      Provider<Context> contextProvider,
      Provider<Repository> repositoryProvider) {
    return new GetUserFavorites_Factory(
        getUserFavoritesMembersInjector, contextProvider, repositoryProvider);
  }
}
