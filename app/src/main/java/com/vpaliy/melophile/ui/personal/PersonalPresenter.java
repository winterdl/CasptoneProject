package com.vpaliy.melophile.ui.personal;

import com.vpaliy.domain.loader.GetMe;
import com.vpaliy.domain.loader.PlaylistHistory;
import com.vpaliy.domain.loader.SingleLoader;
import com.vpaliy.domain.loader.TrackHistory;
import com.vpaliy.domain.model.Playlist;
import com.vpaliy.domain.model.Track;
import java.util.List;
import com.vpaliy.domain.model.User;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import io.reactivex.functions.Consumer;
import static com.vpaliy.melophile.ui.personal.PersonalContract.View;
import static dagger.internal.Preconditions.checkNotNull;
import javax.inject.Inject;
import com.vpaliy.melophile.di.scope.ViewScope;
import android.support.annotation.NonNull;

@ViewScope
public class PersonalPresenter implements PersonalContract.Presenter{

    private View view;
    private LoaderManager manager;
    private Callback<List<Track>> tracksHistory;
    private Callback<List<Playlist>> playlistHistory;
    private Callback<User> myself;

    @Inject
    public PersonalPresenter(TrackHistory tracks,
                             PlaylistHistory playlists,
                             GetMe preciousMe){
        tracksHistory=new Callback<>(tracks,this::catchTrackHistory);
        playlistHistory=new Callback<>(playlists,this::catchPlaylistHistory);
        myself=new Callback<>(preciousMe,this::catchMyself);
    }

    @Override
    public void attachView(@NonNull View view) {
        this.view=checkNotNull(view);
    }

    @Override
    public void start() {
        manager.initLoader(0,null,myself);
        manager.initLoader(1,null,tracksHistory);
        manager.initLoader(2,null,playlistHistory);
    }

    @Override
    public void stop() {
        manager.destroyLoader(0);
        manager.destroyLoader(1);
        manager.destroyLoader(2);
    }

    private void catchPlaylistHistory(List<Playlist> playlistList){
        if(playlistList==null||playlistList.isEmpty()){
            //show empty view
            return;
        }
        view.showPlaylistHistory(playlistList);
    }

    private void catchTrackHistory(List<Track> tracks){
        if(tracks==null||tracks.isEmpty()){
            //TODO show empty
            return;
        }
        view.showTrackHistory(tracks);
    }

    @Override
    public void clearPlaylistHistory() {

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
        ex.printStackTrace();
    }

    private  class Callback<T>
            implements LoaderManager.LoaderCallbacks<T>{

        private SingleLoader<T,Void> loader;
        private Consumer<? super T> consumer;

        Callback(SingleLoader<T,Void> loader,
                        Consumer<? super T> consumer){
            this.loader=loader;
            this.consumer=consumer;
        }

        @Override
        public Loader<T> onCreateLoader(int id, Bundle args) {
            return loader;
        }

        @Override
        public void onLoadFinished(Loader<T> loader, T data) {
            try {
                consumer.accept(data);
            }catch (Exception ex){
                catchError(ex);
                ex.printStackTrace();
            }
        }
        @Override
        public void onLoaderReset(Loader<T> loader) {}
    }
}
