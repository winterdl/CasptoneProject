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
public final class TracksFactory_Factory implements Factory<TracksFactory> {
  private final MembersInjector<TracksFactory> tracksFactoryMembersInjector;

  private final Provider<Context> contextProvider;

  private final Provider<Repository> repositoryProvider;

  public TracksFactory_Factory(
      MembersInjector<TracksFactory> tracksFactoryMembersInjector,
      Provider<Context> contextProvider,
      Provider<Repository> repositoryProvider) {
    assert tracksFactoryMembersInjector != null;
    this.tracksFactoryMembersInjector = tracksFactoryMembersInjector;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
    assert repositoryProvider != null;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public TracksFactory get() {
    return MembersInjectors.injectMembers(
        tracksFactoryMembersInjector,
        new TracksFactory(contextProvider.get(), repositoryProvider.get()));
  }

  public static Factory<TracksFactory> create(
      MembersInjector<TracksFactory> tracksFactoryMembersInjector,
      Provider<Context> contextProvider,
      Provider<Repository> repositoryProvider) {
    return new TracksFactory_Factory(
        tracksFactoryMembersInjector, contextProvider, repositoryProvider);
  }
}
