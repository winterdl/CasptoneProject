package com.vpaliy.domain.loader;

import android.content.Context;
import android.text.TextUtils;

import com.vpaliy.domain.model.Track;
import com.vpaliy.domain.repository.Repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GetUserFavorites extends SingleLoader<List<Track>,String> {

    private Repository repository;

    @Inject
    public GetUserFavorites(Context context, Repository repository){
        super(context);
        this.repository=repository;
    }

    @Override
    public List<Track> load() {
        if(!TextUtils.isEmpty(params)){
            return repository.getUserFavorites(params);
        }
        throw new IllegalArgumentException("Id is null");
    }
}
