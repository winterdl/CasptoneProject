package com.vpaliy.domain.repository;

import com.vpaliy.domain.model.MelophileTheme;
import com.vpaliy.domain.model.Playlist;
import com.vpaliy.domain.model.Track;
import com.vpaliy.domain.model.User;
import com.vpaliy.domain.model.UserDetails;
import java.util.List;

public interface Repository {
    List<Track> getTracksBy(MelophileTheme theme);
    List<Playlist> getPlaylistsBy(MelophileTheme theme);
    UserDetails getUserBy(String id);
    Track getTrackBy(String id);
    Playlist getPlaylistBy(String id);
    List<Track> getUserFavorites(String id);
    List<User> getUserFollowers(String id);
}
