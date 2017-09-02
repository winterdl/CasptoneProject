package com.vpaliy.data.source.local;

import android.text.TextUtils;
import com.vpaliy.data.source.LocalSource;
import com.vpaliy.data.source.local.handler.PlaylistHandler;
import com.vpaliy.data.source.local.handler.TrackHandler;
import com.vpaliy.data.source.local.handler.UserHandler;
import com.vpaliy.domain.model.MelophileTheme;
import com.vpaliy.domain.model.Playlist;
import com.vpaliy.domain.model.Track;
import com.vpaliy.domain.model.User;
import com.vpaliy.domain.model.UserDetails;
import java.util.List;
import io.reactivex.Single;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LocalMusicSource implements LocalSource {

    private PlaylistHandler playlistHandler;
    private TrackHandler trackHandler;
    private UserHandler userHandler;

    @Inject
    public LocalMusicSource(PlaylistHandler playlistHandler,
                            TrackHandler trackHandler,
                            UserHandler userHandler){
        this.playlistHandler=playlistHandler;
        this.trackHandler=trackHandler;
        this.userHandler=userHandler;
    }

    @Override
    public List<Playlist> getPlaylistsBy(MelophileTheme theme) {
        if(theme!=null){
            return playlistHandler.queryByTheme(theme);
        }
        throw new IllegalArgumentException("Theme is null");
    }

    @Override
    public List<Track> getTracksBy(MelophileTheme theme) {
        if(theme!=null){
            return trackHandler.queryByTheme(theme);
        }
        throw new IllegalArgumentException("Theme is null");
    }

    @Override
    public List<Track> getUserFavorites(String id) {
        if(!TextUtils.isEmpty(id)){
            return userHandler.queryFavorites(id);
        }
        throw new IllegalArgumentException("Id is empty");
    }

    @Override
    public List<User> getUserFollowers(String id) {
        if(!TextUtils.isEmpty(id)){
            return userHandler.queryFollowers(id);
        }
        throw new IllegalArgumentException("Id is empty");
    }

    @Override
    public Playlist getPlaylistBy(String id) {
        if(!TextUtils.isEmpty(id)){
            return playlistHandler.query(id);
        }
        throw new IllegalArgumentException("Id is empty or null");
    }

    @Override
    public Track getTrackBy(String id) {
        if(!TextUtils.isEmpty(id)){
            return trackHandler.query(id);
        }
        throw new IllegalArgumentException("Id is null");
    }

    @Override
    public UserDetails getUserBy(String id) {
        return null;
    }

    @Override
    public void insert(Playlist playlist) {
        playlistHandler.insert(playlist);
    }

    @Override
    public void insert(Track track) {
        trackHandler.insert(track);
    }

    @Override
    public void insert(User user) {
        userHandler.insert(user);
    }

    @Override
    public void insert(MelophileTheme theme, Playlist playlist) {
        playlistHandler.insert(theme,playlist);
    }

    @Override
    public void insert(MelophileTheme theme, Track track) {
        trackHandler.insert(theme,track);
    }
}
