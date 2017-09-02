package com.vpaliy.melophile.ui.playlist;

import com.vpaliy.domain.interactor.SaveInteractor;
import com.vpaliy.domain.loader.GetPlaylist;
import com.vpaliy.domain.model.Playlist;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import java.util.LinkedList;
import java.util.List;
import static com.vpaliy.melophile.ui.playlist.PlaylistContract.View;
import static dagger.internal.Preconditions.checkNotNull;
import android.support.annotation.NonNull;
import android.util.Log;

import com.vpaliy.melophile.di.scope.ViewScope;
import com.vpaliy.melophile.ui.base.LoaderCallback;
import com.vpaliy.melophile.ui.playlists.PlaylistsPresenter;

import javax.inject.Inject;

@ViewScope
public class PlaylistPresenter implements PlaylistContract.Presenter{

    private SaveInteractor saveInteractor;
    private LoaderManager manager;
    private LoaderCallback<Playlist,String> playlistLoader;
    private View view;

    @Inject
    public PlaylistPresenter(GetPlaylist playlistUseCase, SaveInteractor saveInteractor){
        this.saveInteractor=saveInteractor;
        this.playlistLoader=new LoaderCallback<>(playlistUseCase,this::catchData)
                .setError(this::catchError);
    }

    @Override
    public void start(String id) {
        playlistLoader.setParams(id);
        manager.initLoader(0,null,playlistLoader);
    }

    private void catchData(Playlist playlist){
        if(playlist!=null){
            saveInteractor.savePlaylist(playlist);
            List<String> tags=tags(playlist);
            if(!tags.isEmpty()) {
                view.showTags(tags);
            }
            view.showButtons();
            view.showUser(playlist.getUser());
            view.showTitle(playlist.getTitle());
            view.showTrackNumber(playlist.getTrackCount());
            view.showTracks(playlist.getTracks());
            view.showDuration(playlist.getDuration());
            view.showPlaylistArt(playlist.getArtUrl());
        }else{
            view.showEmptyMessage();
        }
    }

    private List<String> tags(Playlist playlist){
        List<String> list=new LinkedList<>();
        if(playlist.getTags()!=null){
            list.addAll(playlist.getTags());
        }
        //get the genres
        if(playlist.getGenres()!=null){
            list.addAll(playlist.getGenres());
        }
        return list;
    }
    private void catchError(Throwable ex){
        ex.printStackTrace();
        view.showErrorMessage();
    }

    @Override
    public void attachManager(@NonNull LoaderManager loaderManager) {
        this.manager=checkNotNull(loaderManager);
    }

    @Override
    public void stop() {
        manager.destroyLoader(0);
    }

    @Override
    public void attachView(@NonNull View view) {
        this.view=view;
    }
}
