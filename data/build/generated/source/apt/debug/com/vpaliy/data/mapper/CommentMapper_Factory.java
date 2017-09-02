package com.vpaliy.data.mapper;

import com.vpaliy.domain.model.User;
import com.vpaliy.soundcloud.model.MiniUserEntity;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CommentMapper_Factory implements Factory<CommentMapper> {
  private final MembersInjector<CommentMapper> commentMapperMembersInjector;

  private final Provider<Mapper<User, MiniUserEntity>> mapperProvider;

  public CommentMapper_Factory(
      MembersInjector<CommentMapper> commentMapperMembersInjector,
      Provider<Mapper<User, MiniUserEntity>> mapperProvider) {
    assert commentMapperMembersInjector != null;
    this.commentMapperMembersInjector = commentMapperMembersInjector;
    assert mapperProvider != null;
    this.mapperProvider = mapperProvider;
  }

  @Override
  public CommentMapper get() {
    return MembersInjectors.injectMembers(
        commentMapperMembersInjector, new CommentMapper(mapperProvider.get()));
  }

  public static Factory<CommentMapper> create(
      MembersInjector<CommentMapper> commentMapperMembersInjector,
      Provider<Mapper<User, MiniUserEntity>> mapperProvider) {
    return new CommentMapper_Factory(commentMapperMembersInjector, mapperProvider);
  }
}
