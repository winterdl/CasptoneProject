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
public final class FollowUser_Factory implements Factory<FollowUser> {
  private final MembersInjector<FollowUser> followUserMembersInjector;

  private final Provider<BaseSchedulerProvider> schedulerProvider;

  private final Provider<PersonalRepository> repositoryProvider;

  public FollowUser_Factory(
      MembersInjector<FollowUser> followUserMembersInjector,
      Provider<BaseSchedulerProvider> schedulerProvider,
      Provider<PersonalRepository> repositoryProvider) {
    assert followUserMembersInjector != null;
    this.followUserMembersInjector = followUserMembersInjector;
    assert schedulerProvider != null;
    this.schedulerProvider = schedulerProvider;
    assert repositoryProvider != null;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public FollowUser get() {
    return MembersInjectors.injectMembers(
        followUserMembersInjector,
        new FollowUser(schedulerProvider.get(), repositoryProvider.get()));
  }

  public static Factory<FollowUser> create(
      MembersInjector<FollowUser> followUserMembersInjector,
      Provider<BaseSchedulerProvider> schedulerProvider,
      Provider<PersonalRepository> repositoryProvider) {
    return new FollowUser_Factory(followUserMembersInjector, schedulerProvider, repositoryProvider);
  }
}
