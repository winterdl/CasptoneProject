package com.vpaliy.data.source.local.handler;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserHandler_Factory implements Factory<UserHandler> {
  private final Provider<Context> contextProvider;

  public UserHandler_Factory(Provider<Context> contextProvider) {
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public UserHandler get() {
    return new UserHandler(contextProvider.get());
  }

  public static Factory<UserHandler> create(Provider<Context> contextProvider) {
    return new UserHandler_Factory(contextProvider);
  }
}
