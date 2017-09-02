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
public final class TrackHistory_Factory implements Factory<TrackHistory> {
  private final MembersInjector<TrackHistory> trackHistoryMembersInjector;

  private final Provider<Context> contextProvider;

  private final Provider<PersonalRepository> repositoryProvider;

  public TrackHistory_Factory(
      MembersInjector<TrackHistory> trackHistoryMembersInjector,
      Provider<Context> contextProvider,
      Provider<PersonalRepository> repositoryProvider) {
    assert trackHistoryMembersInjector != null;
    this.trackHistoryMembersInjector = trackHistoryMembersInjector;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
    assert repositoryProvider != null;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public TrackHistory get() {
    return MembersInjectors.injectMembers(
        trackHistoryMembersInjector,
        new TrackHistory(contextProvider.get(), repositoryProvider.get()));
  }

  public static Factory<TrackHistory> create(
      MembersInjector<TrackHistory> trackHistoryMembersInjector,
      Provider<Context> contextProvider,
      Provider<PersonalRepository> repositoryProvider) {
    return new TrackHistory_Factory(
        trackHistoryMembersInjector, contextProvider, repositoryProvider);
  }
}
