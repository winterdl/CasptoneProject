package com.vpaliy.melophile.ui.user.info;

import java.util.List;
import static com.vpaliy.melophile.ui.user.info.UserInfoContract.View;
import static dagger.internal.Preconditions.checkNotNull;
import android.support.annotation.NonNull;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

@SuppressWarnings("WeakerAccess")
public abstract class UserInfoPresenter<T>
        implements UserInfoContract.Presenter<T>,LoaderManager.LoaderCallbacks<List<T>> {

    private View<T> view;
    protected LoaderManager manager;

    @Override
    public void attachView(@NonNull View<T> view) {
        this.view=checkNotNull(view);
    }

    protected void catchData(List<T> data){
        if(data==null||data.isEmpty()){
            view.showEmpty();
        }else{
            view.showTitle();
            view.showInfo(data);
        }
    }

    protected void catchError(Throwable ex){
        ex.printStackTrace();
        view.showError();
    }

    @Override
    public void onLoaderReset(Loader<List<T>> loader) {
        //nothing
    }

    @Override
    public void onLoadFinished(Loader<List<T>> loader, List<T> data) {
        catchData(data);
    }

    @Override
    public void attachManager(@NonNull LoaderManager loaderManager) {
        this.manager=checkNotNull(loaderManager);
    }
}
