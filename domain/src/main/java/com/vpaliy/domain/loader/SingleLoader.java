package com.vpaliy.domain.loader;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v4.content.AsyncTaskLoader;

public abstract class SingleLoader<T,Params> extends AsyncTaskLoader<T>{

    protected Params params;
    private OnErrorListener listener;

    public SingleLoader(Context context){
        super(context);
    }

    @Override
    public T loadInBackground() {
        try {
            return load();
        }catch (Throwable ex){
            listener.onError(ex);
        }
        return null;
    }

    @Override
    public void deliverResult(T data) {
        if (isReset()) {
            return;
        }

        if (isStarted()) {
            super.deliverResult(data);
        }
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    protected void onReset() {
        super.onReset();
        stopLoading();
    }

    public abstract T load();

    public void setParams(Params params) {
        this.params = params;
    }

    public SingleLoader<T,Params> setListener(OnErrorListener listener) {
        this.listener = listener;
        return this;
    }

    public interface OnErrorListener {
        void onError(Throwable ex);
    }
}
