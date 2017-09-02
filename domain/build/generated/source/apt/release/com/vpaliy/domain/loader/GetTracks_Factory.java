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
public final class GetTracks_Factory implements Factory<GetTracks> {
  private final MembersInjector<GetTracks> getTracksMembersInjector;

  private final Provider<Context> contextProvider;

  private final Provider<Repository> repositoryProvider;

  public GetTracks_Factory(
      MembersInjector<GetTracks> getTracksMembersInjector,
      Provider<Context> contextProvider,
      Provider<Repository> repositoryProvider) {
    assert getTracksMembersInjector != null;
    this.getTracksMembersInjector = getTracksMembersInjector;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
    assert repositoryProvider != null;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetTracks get() {
    return MembersInjectors.injectMembers(
        getTracksMembersInjector, new GetTracks(contextProvider.get(), repositoryProvider.get()));
  }

  public static Factory<GetTracks> create(
      MembersInjector<GetTracks> getTracksMembersInjector,
      Provider<Context> contextProvider,
      Provider<Repository> repositoryProvider) {
    return new GetTracks_Factory(getTracksMembersInjector, contextProvider, repositoryProvider);
  }
}
