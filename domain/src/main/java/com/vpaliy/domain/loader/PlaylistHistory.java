package com.vpaliy.domain.loader;

import android.content.Context;

import com.vpaliy.domain.model.Playlist;
import com.vpaliy.domain.model.Track;
import com.vpaliy.domain.repository.PersonalRepository;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PlaylistHistory extends SingleLoader<List<Playlist>,Void> {

    private PersonalRepository repository;

    @Inject
    public PlaylistHistory(Context context, PersonalRepository repository){
        super(context);
        this.repository=repository;
    }

    @Override
    public List<Playlist> load() {
        return repository.fetchPlaylistHistory();
    }

    public void clearHistory(){
        repository.clearPlaylists();
    }
}
