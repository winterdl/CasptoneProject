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
public final class GetTrack_Factory implements Factory<GetTrack> {
  private final MembersInjector<GetTrack> getTrackMembersInjector;

  private final Provider<Context> contextProvider;

  private final Provider<Repository> repositoryProvider;

  public GetTrack_Factory(
      MembersInjector<GetTrack> getTrackMembersInjector,
      Provider<Context> contextProvider,
      Provider<Repository> repositoryProvider) {
    assert getTrackMembersInjector != null;
    this.getTrackMembersInjector = getTrackMembersInjector;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
    assert repositoryProvider != null;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetTrack get() {
    return MembersInjectors.injectMembers(
        getTrackMembersInjector, new GetTrack(contextProvider.get(), repositoryProvider.get()));
  }

  public static Factory<GetTrack> create(
      MembersInjector<GetTrack> getTrackMembersInjector,
      Provider<Context> contextProvider,
      Provider<Repository> repositoryProvider) {
    return new GetTrack_Factory(getTrackMembersInjector, contextProvider, repositoryProvider);
  }
}
