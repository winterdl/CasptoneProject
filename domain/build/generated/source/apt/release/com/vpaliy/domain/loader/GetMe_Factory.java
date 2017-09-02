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
public final class GetMe_Factory implements Factory<GetMe> {
  private final MembersInjector<GetMe> getMeMembersInjector;

  private final Provider<Context> contextProvider;

  private final Provider<PersonalRepository> repositoryProvider;

  public GetMe_Factory(
      MembersInjector<GetMe> getMeMembersInjector,
      Provider<Context> contextProvider,
      Provider<PersonalRepository> repositoryProvider) {
    assert getMeMembersInjector != null;
    this.getMeMembersInjector = getMeMembersInjector;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
    assert repositoryProvider != null;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetMe get() {
    return MembersInjectors.injectMembers(
        getMeMembersInjector, new GetMe(contextProvider.get(), repositoryProvider.get()));
  }

  public static Factory<GetMe> create(
      MembersInjector<GetMe> getMeMembersInjector,
      Provider<Context> contextProvider,
      Provider<PersonalRepository> repositoryProvider) {
    return new GetMe_Factory(getMeMembersInjector, contextProvider, repositoryProvider);
  }
}
