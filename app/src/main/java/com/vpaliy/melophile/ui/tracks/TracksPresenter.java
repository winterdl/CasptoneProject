package com.vpaliy.melophile.ui.tracks;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import com.vpaliy.domain.loader.GetTracks;
import com.vpaliy.domain.loader.ThemeFactory;
import com.vpaliy.domain.model.TrackSet;
import com.vpaliy.melophile.di.scope.ViewScope;
import javax.inject.Inject;
import android.support.annotation.NonNull;
import static com.vpaliy.melophile.ui.tracks.TracksContract.View;
import static dagger.internal.Preconditions.checkNotNull;

@ViewScope
public class TracksPresenter implements TracksContract.Presenter,
        LoaderManager.LoaderCallbacks<TrackSet>{

    private ThemeFactory<GetTracks> tracksThemeFactory;
    private LoaderManager manager;
    private View view;

    @Inject
    public TracksPresenter(ThemeFactory<GetTracks> tracksThemeFactory){
        this.tracksThemeFactory=tracksThemeFactory;
    }

    @Override
    public void start() {
        view.showLoading();
        for(int index=0;index<tracksThemeFactory.themesCount();index++) {
            manager.initLoader(index, null, this).forceLoad();
        }
    }

    @Override
    public void onLoadFinished(Loader<TrackSet> loader, TrackSet data) {
        catchData(data);
    }

    @Override
    public void onLoaderReset(Loader<TrackSet> loader) {
        //nothing
    }

    @Override
    public Loader<TrackSet> onCreateLoader(int id, Bundle args) {
        return tracksThemeFactory.forTheme(id).setListener(this::catchError);
    }

    private void catchData(TrackSet trackSet){
        view.hideLoading();
        if(trackSet!=null){
            view.showTrackSet(trackSet);
            return;
        }
        view.showEmptyMessage();
    }

    private void catchError(Throwable ex){
        ex.printStackTrace();
        view.showErrorMessage();
    }

    @Override
    public void stop() {
        for(int index=0;index<tracksThemeFactory.themesCount();index++){
            manager.destroyLoader(index);
        }
    }

    @Override
    public void attachView(@NonNull TracksContract.View view) {
        this.view=view;
    }

    @Override
    public void attachManager(@NonNull LoaderManager loaderManager) {
        this.manager=checkNotNull(loaderManager);
    }
}
