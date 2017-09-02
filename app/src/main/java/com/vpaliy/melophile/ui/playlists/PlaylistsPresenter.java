package com.vpaliy.melophile.ui.playlists;

import com.vpaliy.domain.loader.GetPlaylists;
import com.vpaliy.domain.loader.ThemeFactory;
import com.vpaliy.domain.model.PlaylistSet;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import static com.vpaliy.melophile.ui.playlists.PlaylistsContract.View;
import static dagger.internal.Preconditions.checkNotNull;
import android.support.annotation.NonNull;
import com.vpaliy.melophile.di.scope.ViewScope;
import javax.inject.Inject;

@ViewScope
public class PlaylistsPresenter implements PlaylistsContract.Presenter,
                LoaderManager.LoaderCallbacks<PlaylistSet>{

    private ThemeFactory<GetPlaylists> playlistsFactory;
    private LoaderManager manager;
    private View view;

    @Inject
    public PlaylistsPresenter(ThemeFactory<GetPlaylists> playlistsFactory){
        this.playlistsFactory = playlistsFactory;
    }

    @Override
    public void start() {
        view.showLoading();
        for(int index = 0; index< playlistsFactory.themesCount(); index++){
            manager.initLoader(index,null,this);
        }
    }

    @Override
    public Loader<PlaylistSet> onCreateLoader(int id, Bundle args) {
        return playlistsFactory.forTheme(id)
                .setListener(this::catchError);
    }

    @Override
    public void onLoaderReset(Loader<PlaylistSet> loader) {
        // nothing
    }

    @Override
    public void onLoadFinished(Loader<PlaylistSet> loader, PlaylistSet data) {
        catchData(data);
    }

    private void catchData(PlaylistSet set){
        view.hideLoading();
        if(set!=null){
            view.showPlaylists(set);
            return;
        }
        view.showEmptyMessage();
    }

    private void catchError(Throwable ex){
        ex.printStackTrace();
        view.hideLoading();
        view.showErrorMessage();
    }

    @Override
    public void attachManager(@NonNull LoaderManager loaderManager) {
        this.manager=checkNotNull(loaderManager);
    }

    @Override
    public void stop() {
        for(int index=0;index<playlistsFactory.themesCount();index++){
            manager.destroyLoader(index);
        }
    }

    @Override
    public void attachView(@NonNull View view) {
        this.view=checkNotNull(view);
    }
}
