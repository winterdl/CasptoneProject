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
public final class GetUserFollowers_Factory implements Factory<GetUserFollowers> {
  private final MembersInjector<GetUserFollowers> getUserFollowersMembersInjector;

  private final Provider<Context> contextProvider;

  private final Provider<Repository> repositoryProvider;

  public GetUserFollowers_Factory(
      MembersInjector<GetUserFollowers> getUserFollowersMembersInjector,
      Provider<Context> contextProvider,
      Provider<Repository> repositoryProvider) {
    assert getUserFollowersMembersInjector != null;
    this.getUserFollowersMembersInjector = getUserFollowersMembersInjector;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
    assert repositoryProvider != null;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetUserFollowers get() {
    return MembersInjectors.injectMembers(
        getUserFollowersMembersInjector,
        new GetUserFollowers(contextProvider.get(), repositoryProvider.get()));
  }

  public static Factory<GetUserFollowers> create(
      MembersInjector<GetUserFollowers> getUserFollowersMembersInjector,
      Provider<Context> contextProvider,
      Provider<Repository> repositoryProvider) {
    return new GetUserFollowers_Factory(
        getUserFollowersMembersInjector, contextProvider, repositoryProvider);
  }
}
