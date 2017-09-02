package com.vpaliy.melophile.ui.personal;

import com.vpaliy.domain.loader.GetMe;
import com.vpaliy.domain.loader.TrackHistory;
import com.vpaliy.domain.model.Track;
import java.util.List;
import com.vpaliy.domain.model.User;
import android.support.v4.app.LoaderManager;
import static com.vpaliy.melophile.ui.personal.PersonalContract.View;
import static dagger.internal.Preconditions.checkNotNull;
import com.vpaliy.melophile.ui.base.LoaderCallback;
import javax.inject.Inject;
import com.vpaliy.melophile.di.scope.ViewScope;
import android.support.annotation.NonNull;

@ViewScope
public class PersonalPresenter implements PersonalContract.Presenter{

    private View view;
    private LoaderManager manager;
    private LoaderCallback<List<Track>,Void> tracksHistory;
    private LoaderCallback<User,Void> myself;

    @Inject
    public PersonalPresenter(TrackHistory tracks, GetMe preciousMe){
        tracksHistory=new LoaderCallback<>(tracks,this::catchTrackHistory)
                .setError(this::catchError);
        myself=new LoaderCallback<>(preciousMe,this::catchMyself)
                .setError(this::catchError);
    }

    @Override
    public void attachView(@NonNull View view) {
        this.view=checkNotNull(view);
    }

    @Override
    public void start() {
        manager.initLoader(0,null,myself);
        manager.initLoader(1,null,tracksHistory);
    }

    @Override
    public void stop() {
        manager.destroyLoader(0);
        manager.destroyLoader(1);
    }

    private void catchTrackHistory(List<Track> tracks){
        if(tracks==null||tracks.isEmpty()){
            view.showEmptyHistoryMessage();
            return;
        }
        view.showTrackHistory(tracks);
    }

    @Override
    public void clearTrackHistory() {
    }

    @Override
    public void attachManager(@NonNull LoaderManager loaderManager) {
        this.manager=checkNotNull(loaderManager);
    }

    private void catchMyself(User user){
        if(user!=null){
            view.showMyself(user);
        }
    }

    private void catchError(Throwable ex){
        view.showErrorMessage();
        ex.printStackTrace();
    }
}
