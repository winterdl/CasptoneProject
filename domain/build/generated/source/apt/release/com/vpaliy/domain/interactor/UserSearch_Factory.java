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
public final class UserSearch_Factory implements Factory<UserSearch> {
  private final MembersInjector<UserSearch> userSearchMembersInjector;

  private final Provider<BaseSchedulerProvider> schedulerProvider;

  private final Provider<SearchRepository> searchRepositoryProvider;

  public UserSearch_Factory(
      MembersInjector<UserSearch> userSearchMembersInjector,
      Provider<BaseSchedulerProvider> schedulerProvider,
      Provider<SearchRepository> searchRepositoryProvider) {
    assert userSearchMembersInjector != null;
    this.userSearchMembersInjector = userSearchMembersInjector;
    assert schedulerProvider != null;
    this.schedulerProvider = schedulerProvider;
    assert searchRepositoryProvider != null;
    this.searchRepositoryProvider = searchRepositoryProvider;
  }

  @Override
  public UserSearch get() {
    return MembersInjectors.injectMembers(
        userSearchMembersInjector,
        new UserSearch(schedulerProvider.get(), searchRepositoryProvider.get()));
  }

  public static Factory<UserSearch> create(
      MembersInjector<UserSearch> userSearchMembersInjector,
      Provider<BaseSchedulerProvider> schedulerProvider,
      Provider<SearchRepository> searchRepositoryProvider) {
    return new UserSearch_Factory(
        userSearchMembersInjector, schedulerProvider, searchRepositoryProvider);
  }
}
