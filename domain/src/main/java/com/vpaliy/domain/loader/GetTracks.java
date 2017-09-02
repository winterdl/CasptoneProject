package com.vpaliy.domain.loader;

import android.content.Context;
import com.vpaliy.domain.model.MelophileTheme;
import com.vpaliy.domain.model.Track;
import com.vpaliy.domain.model.TrackSet;
import com.vpaliy.domain.repository.Repository;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GetTracks extends SingleLoader<TrackSet,MelophileTheme> {

    private Repository repository;

    @Inject
    public GetTracks(Context context, Repository repository){
        super(context);
        this.repository=repository;
    }

    @Override
    public TrackSet load() {
        if(params!=null){
            List<Track> tracks=repository.getTracksBy(params);
            return new TrackSet(params,tracks);
        }
        throw new IllegalArgumentException("Params should not be null!");
    }
}
