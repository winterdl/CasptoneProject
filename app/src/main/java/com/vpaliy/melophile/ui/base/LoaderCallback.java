package com.vpaliy.melophile.ui.base;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import com.vpaliy.domain.loader.SingleLoader;
import io.reactivex.functions.Consumer;


public final class LoaderCallback<T,Params> implements LoaderManager.LoaderCallbacks<T> {

    private SingleLoader<T,Params> loader;
    private Consumer<? super T> consumer;
    private Consumer<? super Throwable> error;

    public LoaderCallback(SingleLoader<T,Params> loader, Consumer<? super T> consumer){
        this.loader=loader;
        this.consumer=consumer;

    }

    public LoaderCallback<T,Params> setParams(Params params){
        loader.setParams(params);
        return this;
    }

    public LoaderCallback<T,Params> setError(Consumer<? super Throwable> error){
        this.error= error;
        return this;
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
            if(error!=null){
                try {
                    error.accept(ex);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            ex.printStackTrace();
        }
    }
    @Override
    public void onLoaderReset(Loader<T> loader) {}
}