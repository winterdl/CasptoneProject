package com.vpaliy.melophile.ui.base;
import android.support.annotation.NonNull;
import android.support.v4.app.LoaderManager;

public interface BasePresenter<V extends BaseView> {
    void attachView(@NonNull V view);
    void attachManager(@NonNull LoaderManager loaderManager);
}