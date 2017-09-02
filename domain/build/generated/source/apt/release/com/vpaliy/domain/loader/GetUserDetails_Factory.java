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
public final class GetUserDetails_Factory implements Factory<GetUserDetails> {
  private final MembersInjector<GetUserDetails> getUserDetailsMembersInjector;

  private final Provider<Context> contextProvider;

  private final Provider<Repository> repositoryProvider;

  public GetUserDetails_Factory(
      MembersInjector<GetUserDetails> getUserDetailsMembersInjector,
      Provider<Context> contextProvider,
      Provider<Repository> repositoryProvider) {
    assert getUserDetailsMembersInjector != null;
    this.getUserDetailsMembersInjector = getUserDetailsMembersInjector;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
    assert repositoryProvider != null;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetUserDetails get() {
    return MembersInjectors.injectMembers(
        getUserDetailsMembersInjector,
        new GetUserDetails(contextProvider.get(), repositoryProvider.get()));
  }

  public static Factory<GetUserDetails> create(
      MembersInjector<GetUserDetails> getUserDetailsMembersInjector,
      Provider<Context> contextProvider,
      Provider<Repository> repositoryProvider) {
    return new GetUserDetails_Factory(
        getUserDetailsMembersInjector, contextProvider, repositoryProvider);
  }
}
