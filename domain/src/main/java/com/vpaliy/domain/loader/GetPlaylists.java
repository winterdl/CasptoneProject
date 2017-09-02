package com.vpaliy.domain.loader;

import android.content.Context;
import com.vpaliy.domain.model.MelophileTheme;
import com.vpaliy.domain.model.Playlist;
import com.vpaliy.domain.model.PlaylistSet;
import com.vpaliy.domain.repository.Repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GetPlaylists extends SingleLoader<PlaylistSet,MelophileTheme>{

    private Repository repository;

    @Inject
    public GetPlaylists(Context context, Repository repository){
        super(context);
        this.repository=repository;
    }

    public Repository getRepository() {
        return repository;
    }

    @Override
    public PlaylistSet load() {
        if(params!=null){
            List<Playlist> result=repository.getPlaylistsBy(params);
            return new PlaylistSet(params,result);
        }
        throw new IllegalArgumentException("Params are null!");
    }
}
