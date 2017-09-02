package com.vpaliy.melophile;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.reflect.TypeToken;
import com.vpaliy.melophile.di.component.ApplicationComponent;
import com.vpaliy.melophile.di.component.DaggerApplicationComponent;
import com.vpaliy.melophile.di.component.DaggerPlayerComponent;
import com.vpaliy.melophile.di.component.PlayerComponent;
import com.vpaliy.melophile.di.module.ApplicationModule;
import com.vpaliy.melophile.di.module.DataModule;
import com.vpaliy.melophile.di.module.InteractorModule;
import com.vpaliy.melophile.di.module.MapperModule;
import com.vpaliy.melophile.di.module.NetworkModule;
import com.vpaliy.melophile.di.module.PlaybackModule;
import com.vpaliy.melophile.ui.utils.BundleUtils;
import com.vpaliy.melophile.ui.utils.Constants;
import com.vpaliy.melophile.widget.MusicWidget;
import com.vpaliy.soundcloud.model.Token;

public class App extends Application {

    private ApplicationComponent applicationComponent;
    private PlayerComponent playerComponent;
    private static App INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    private void initializePlayerComponent() {
        playerComponent= DaggerPlayerComponent.builder()
                .applicationComponent(applicationComponent)
                .playbackModule(new PlaybackModule()).build();
    }

    public void setApplicationComponent(ApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }

    public void appendToken(Token token){
        initializeAppComponent(token);
    }

    private void initializeAppComponent(Token token){
        //just in case if the app works in the background with the playback service
        if(applicationComponent==null) {
            applicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .dataModule(new DataModule())
                    .networkModule(new NetworkModule(token))
                    .mapperModule(new MapperModule())
                    .interactorModule(new InteractorModule())
                    .build();
            initializePlayerComponent();
        }
    }

    @NonNull
    public static App appInstance() {
        return INSTANCE;
    }

    public ApplicationComponent appComponent() {
        return applicationComponent;
    }

    private Token fetchToken(){
        SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(this);
        String jsonToken= sharedPreferences.getString(Constants.EXTRA_TOKEN,null);
        if(!TextUtils.isEmpty(jsonToken)) {
            return BundleUtils.convertFromJsonString(jsonToken, new TypeToken<Token>() {
            }.getType());
        }
        return null;
    }

    public void injectWidget(MusicWidget widget){
        if(playerComponent==null) {
            Token token = fetchToken();
            if (token != null) {
                initializeAppComponent(token);
                playerComponent.inject(widget);
                return;
            }
        }
        playerComponent.inject(widget);
    }

    public PlayerComponent playerComponent(){
        if(playerComponent==null){
            initializeAppComponent(fetchToken());
        }
        return playerComponent;
    }
}