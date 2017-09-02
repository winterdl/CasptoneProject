package com.vpaliy.domain.model;

import java.util.List;

public class UserDetails {

    private User user;
    private List<Track> tracks;
    private List<Playlist> playlists;
    private List<Track> favoriteTracks;

    public void setUser(User user) {
        this.user = user;
    }

    public void setFavoriteTracks(List<Track> favoriteTracks) {
        this.favoriteTracks = favoriteTracks;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public User getUser() {
        return user;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public List<Track> getFavoriteTracks() {
        return favoriteTracks;
    }

    public List<Track> getTracks() {
        return tracks;
    }
}
