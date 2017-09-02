package com.vpaliy.melophile.ui.user.info;

import android.os.Bundle;
import android.support.v4.content.Loader;
import com.vpaliy.domain.loader.GetUserFavorites;
import com.vpaliy.domain.model.Track;
import java.util.List;
import com.vpaliy.melophile.di.scope.ViewScope;
import javax.inject.Inject;

@ViewScope
public class FavoritePresenter extends UserInfoPresenter<Track> {

    private GetUserFavorites favoritesUseCase;

    @Inject
    public FavoritePresenter(GetUserFavorites favoritesUseCase){
        this.favoritesUseCase=favoritesUseCase;
    }

    @Override
    public void start(String id) {
        favoritesUseCase.setParams(id);
        manager.initLoader(0,null,this);
    }

    @Override
    public void stop() {
        manager.destroyLoader(0);
    }

    @Override
    public Loader<List<Track>> onCreateLoader(int id, Bundle args) {
        return favoritesUseCase.setListener(this::catchError);
    }
}
