package com.vpaliy.domain.loader;

import android.content.Context;
import com.vpaliy.domain.model.Track;
import com.vpaliy.domain.repository.PersonalRepository;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TrackHistory extends SingleLoader<List<Track>,Void> {

    private PersonalRepository repository;

    @Inject
    public TrackHistory(Context context, PersonalRepository repository){
        super(context);
        this.repository=repository;
    }

    @Override
    public List<Track> load() {
        return repository.fetchTrackHistory();
    }

    public void clearHistory(){
        repository.clearTracks();
    }
}
