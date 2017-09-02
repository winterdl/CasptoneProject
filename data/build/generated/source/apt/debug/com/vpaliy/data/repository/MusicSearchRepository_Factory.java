package com.vpaliy.data.repository;

import com.vpaliy.data.mapper.Mapper;
import com.vpaliy.data.source.SearchSource;
import com.vpaliy.domain.model.Playlist;
import com.vpaliy.domain.model.Track;
import com.vpaliy.domain.model.User;
import com.vpaliy.soundcloud.model.PlaylistEntity;
import com.vpaliy.soundcloud.model.TrackEntity;
import com.vpaliy.soundcloud.model.UserEntity;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MusicSearchRepository_Factory implements Factory<MusicSearchRepository> {
  private final Provider<SearchSource> searchSourceProvider;

  private final Provider<Mapper<Track, TrackEntity>> trackMapperProvider;

  private final Provider<Mapper<Playlist, PlaylistEntity>> playlistMapperProvider;

  private final Provider<Mapper<User, UserEntity>> userMapperProvider;

  public MusicSearchRepository_Factory(
      Provider<SearchSource> searchSourceProvider,
      Provider<Mapper<Track, TrackEntity>> trackMapperProvider,
      Provider<Mapper<Playlist, PlaylistEntity>> playlistMapperProvider,
      Provider<Mapper<User, UserEntity>> userMapperProvider) {
    assert searchSourceProvider != null;
    this.searchSourceProvider = searchSourceProvider;
    assert trackMapperProvider != null;
    this.trackMapperProvider = trackMapperProvider;
    assert playlistMapperProvider != null;
    this.playlistMapperProvider = playlistMapperProvider;
    assert userMapperProvider != null;
    this.userMapperProvider = userMapperProvider;
  }

  @Override
  public MusicSearchRepository get() {
    return new MusicSearchRepository(
        searchSourceProvider.get(),
        trackMapperProvider.get(),
        playlistMapperProvider.get(),
        userMapperProvider.get());
  }

  public static Factory<MusicSearchRepository> create(
      Provider<SearchSource> searchSourceProvider,
      Provider<Mapper<Track, TrackEntity>> trackMapperProvider,
      Provider<Mapper<Playlist, PlaylistEntity>> playlistMapperProvider,
      Provider<Mapper<User, UserEntity>> userMapperProvider) {
    return new MusicSearchRepository_Factory(
        searchSourceProvider, trackMapperProvider, playlistMapperProvider, userMapperProvider);
  }
}
