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
public final class LoveTrack_Factory implements Factory<LoveTrack> {
  private final MembersInjector<LoveTrack> loveTrackMembersInjector;

  private final Provider<BaseSchedulerProvider> schedulerProvider;

  private final Provider<PersonalRepository> repositoryProvider;

  public LoveTrack_Factory(
      MembersInjector<LoveTrack> loveTrackMembersInjector,
      Provider<BaseSchedulerProvider> schedulerProvider,
      Provider<PersonalRepository> repositoryProvider) {
    assert loveTrackMembersInjector != null;
    this.loveTrackMembersInjector = loveTrackMembersInjector;
    assert schedulerProvider != null;
    this.schedulerProvider = schedulerProvider;
    assert repositoryProvider != null;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public LoveTrack get() {
    return MembersInjectors.injectMembers(
        loveTrackMembersInjector, new LoveTrack(schedulerProvider.get(), repositoryProvider.get()));
  }

  public static Factory<LoveTrack> create(
      MembersInjector<LoveTrack> loveTrackMembersInjector,
      Provider<BaseSchedulerProvider> schedulerProvider,
      Provider<PersonalRepository> repositoryProvider) {
    return new LoveTrack_Factory(loveTrackMembersInjector, schedulerProvider, repositoryProvider);
  }
}
