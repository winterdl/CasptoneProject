package com.vpaliy.domain.loader;

import android.content.Context;
import android.text.TextUtils;
import com.vpaliy.domain.model.Playlist;
import com.vpaliy.domain.repository.Repository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GetPlaylist extends SingleLoader<Playlist,String> {

    private Repository repository;

    @Inject
    public GetPlaylist(Context context, Repository repository){
        super(context);
        this.repository=repository;
    }

    @Override
    public Playlist load() {
        if(!TextUtils.isEmpty(params)){
            return repository.getPlaylistBy(params);
        }
        throw new IllegalArgumentException("Id is null!");
    }
}
