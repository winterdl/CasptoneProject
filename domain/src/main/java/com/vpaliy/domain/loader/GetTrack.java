package com.vpaliy.domain.loader;

import android.content.Context;
import android.text.TextUtils;

import com.vpaliy.domain.model.Track;
import com.vpaliy.domain.repository.Repository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GetTrack extends SingleLoader<Track,String> {

    private Repository repository;

    @Inject
    public GetTrack(Context context, Repository repository){
        super(context);
        this.repository=repository;
    }

    @Override
    public Track load() {
        if(!TextUtils.isEmpty(params)){
            return repository.getTrackBy(params);
        }
        throw new IllegalArgumentException("Id is not null!");
    }
}
