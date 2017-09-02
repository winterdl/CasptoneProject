package com.vpaliy.melophile.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.View;
import android.widget.RemoteViews;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.vpaliy.melophile.R;
import com.vpaliy.melophile.playback.service.MediaTasks;
import com.vpaliy.melophile.playback.service.MusicPlaybackService;
import com.vpaliy.melophile.ui.track.TrackActivity;
import com.vpaliy.melophile.ui.utils.Constants;

public class MusicWidget extends AppWidgetProvider {

    private static final String ACTION_SHOW_PROGRESS="com.vpaliy.melophile.show_progress";

    private  void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                  int[] ids,MediaMetadataCompat metadataCompat) {
        RemoteViews views=new RemoteViews(context.getPackageName(), R.layout.widget_standard);
        views.setViewVisibility(R.id.container, View.VISIBLE);
        views.setViewVisibility(R.id.cover,View.VISIBLE);
        views.setViewVisibility(R.id.progress_bar,View.GONE);
        views.setViewVisibility(R.id.title,View.VISIBLE);
        views.setViewVisibility(R.id.author_message,View.VISIBLE);
        views.setOnClickPendingIntent(R.id.root,null);
        views.setOnClickPendingIntent(R.id.prev,prev(context));
        views.setOnClickPendingIntent(R.id.next,next(context));
        views.setOnClickPendingIntent(R.id.play_pause,pause(context));
        views.setOnClickPendingIntent(R.id.cover,contentIntent(context));
        if(metadataCompat!=null){
            views.setTextViewText(R.id.title,metadataCompat.getText(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE));
            views.setTextViewText(R.id.author_message,metadataCompat.getText(MediaMetadataCompat.METADATA_KEY_ARTIST));
            String imageUrl=metadataCompat.getString(MediaMetadataCompat.METADATA_KEY_ALBUM_ART_URI);
            Glide.with(context)
                    .load(imageUrl)
                    .asBitmap()
                    .priority(Priority.IMMEDIATE)
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                            views.setImageViewBitmap(R.id.cover,resource);
                            appWidgetManager.updateAppWidget(ids,views);
                        }
                    });
        }
    }

    private PendingIntent prev(Context context){
        Intent prevIntent=new Intent(context,MusicPlaybackService.class);
        prevIntent.setAction(MediaTasks.ACTION_PREV);
        return PendingIntent.getService(context,
                0,
                prevIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private PendingIntent next(Context context){
        Intent nextIntent=new Intent(context,MusicPlaybackService.class);
        nextIntent.setAction(MediaTasks.ACTION_NEXT);
        return PendingIntent.getService(context,
                1,
                nextIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private PendingIntent pause(Context context){
        Intent pauseIntent=new Intent(context,MusicPlaybackService.class);
        pauseIntent.setAction(MediaTasks.ACTION_PAUSE);
        return PendingIntent.getService(context,
                2,
                pauseIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private PendingIntent play(Context context){
        Intent playIntent=new Intent(context,MusicPlaybackService.class);
        playIntent.setAction(MediaTasks.ACTION_PLAY);
        return PendingIntent.getService(context,
                3,
                playIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private PendingIntent contentIntent(Context context){
        Intent startActivityIntent=new Intent(context, TrackActivity.class);
        startActivityIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP |
                Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return PendingIntent.getActivity(context,
                4,
                startActivityIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private PendingIntent startIntent(Context context){
        Intent playIntent=new Intent(context,MusicPlaybackService.class);
        playIntent.setAction(MediaTasks.ACTION_START_WIDGET);
        return PendingIntent.getService(context,
                3,
                playIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private PendingIntent selfIntent(Context context, String action) {
        Intent intent = new Intent(context, getClass());
        intent.setAction(action);
        return PendingIntent.getBroadcast(context, 5, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        RemoteViews views=new RemoteViews(context.getPackageName(), R.layout.widget_standard);
        views.setOnClickPendingIntent(R.id.root,selfIntent(context,ACTION_SHOW_PROGRESS));
        views.setViewVisibility(R.id.title,View.INVISIBLE);
        views.setViewVisibility(R.id.author_message,View.VISIBLE);
        views.setViewVisibility(R.id.container,View.INVISIBLE);
        views.setTextViewText(R.id.author_message,context.getString(R.string.tap_to_continue_message));
        views.setOnClickPendingIntent(R.id.cover,contentIntent(context));
        Glide.with(context)
                .load(R.drawable.play_pause)
                .asBitmap()
                .priority(Priority.IMMEDIATE)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        views.setImageViewBitmap(R.id.cover,resource);
                        appWidgetManager.updateAppWidget(appWidgetIds,views);
                    }
                });
    }

    private void updateAppWidgetState(Context context, AppWidgetManager appWidgetManager,
                                      int[] ids,PlaybackStateCompat stateCompat) {
        if(stateCompat!=null) {
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_standard);
            views.setOnClickPendingIntent(R.id.prev, prev(context));
            views.setOnClickPendingIntent(R.id.next, next(context));
            switch (stateCompat.getState()){
                case PlaybackStateCompat.STATE_STOPPED:
                case PlaybackStateCompat.STATE_PAUSED:
                    views.setImageViewResource(R.id.play_pause,R.drawable.ic_play);
                    views.setOnClickPendingIntent(R.id.play_pause, play(context));
                    break;
                case PlaybackStateCompat.STATE_PLAYING:
                    views.setImageViewResource(R.id.play_pause,R.drawable.ic_pause);
                    views.setOnClickPendingIntent(R.id.play_pause,pause(context));
                    break;
            }
            appWidgetManager.updateAppWidget(ids,views);
        }
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        String action=intent.getAction();
        if(action.equals(MediaTasks.ACTION_UPDATE)){
            MediaMetadataCompat metadataCompat=intent.getParcelableExtra(Constants.EXTRA_DATA);
            PlaybackStateCompat stateCompat=intent.getParcelableExtra(Constants.EXTRA_PLAYBACK_STATE);
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            ComponentName thisAppWidget = new ComponentName(context.getPackageName(), this.getClass().getName());
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(thisAppWidget);
            if(stateCompat!=null){
                updateAppWidgetState(context,appWidgetManager,appWidgetIds,stateCompat);
            }else if(metadataCompat!=null){
                updateAppWidget(context,appWidgetManager,appWidgetIds,metadataCompat);
            }
        }else if(action.equals(ACTION_SHOW_PROGRESS)){
            showProgress(context);
        }else if(action.equals(MediaTasks.ACTION_STOP_WIDGET)){
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            ComponentName thisAppWidget = new ComponentName(context.getPackageName(), this.getClass().getName());
            onUpdate(context,appWidgetManager,appWidgetManager.getAppWidgetIds(thisAppWidget));
        }else {
            super.onReceive(context, intent);
        }
    }

    private void showProgress(Context context){
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        ComponentName thisAppWidget = new ComponentName(context.getPackageName(), this.getClass().getName());
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(thisAppWidget);
        RemoteViews views=new RemoteViews(context.getPackageName(), R.layout.widget_standard);
        views.setOnClickPendingIntent(R.id.root,null);
        views.setViewVisibility(R.id.progress_bar,View.VISIBLE);
        views.setViewVisibility(R.id.author_message,View.INVISIBLE);
        appWidgetManager.updateAppWidget(appWidgetIds,views);
        try {
            startIntent(context).send();
        }catch (PendingIntent.CanceledException ex){
            ex.printStackTrace();
        }
    }
}
