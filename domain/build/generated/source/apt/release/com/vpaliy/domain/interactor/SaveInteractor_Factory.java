package com.vpaliy.domain.interactor;

import com.vpaliy.domain.repository.PersonalRepository;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SaveInteractor_Factory implements Factory<SaveInteractor> {
  private final Provider<PersonalRepository> repositoryProvider;

  public SaveInteractor_Factory(Provider<PersonalRepository> repositoryProvider) {
    assert repositoryProvider != null;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SaveInteractor get() {
    return new SaveInteractor(repositoryProvider.get());
  }

  public static Factory<SaveInteractor> create(Provider<PersonalRepository> repositoryProvider) {
    return new SaveInteractor_Factory(repositoryProvider);
  }
}
