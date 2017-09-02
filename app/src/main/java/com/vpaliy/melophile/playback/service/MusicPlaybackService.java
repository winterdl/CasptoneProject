package com.vpaliy.melophile.playback.service;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserServiceCompat;
import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaButtonReceiver;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;

import com.vpaliy.domain.loader.TrackHistory;
import com.vpaliy.domain.model.Track;
import com.vpaliy.domain.playback.QueueManager;
import com.vpaliy.domain.repository.PersonalRepository;
import com.vpaliy.melophile.App;
import com.vpaliy.melophile.playback.PlaybackManager;
import com.vpaliy.melophile.ui.track.TrackActivity;
import com.vpaliy.melophile.ui.utils.Constants;

import static com.vpaliy.melophile.playback.MediaHelper.MEDIA_ID_EMPTY_ROOT;
import static com.vpaliy.melophile.playback.MediaHelper.MEDIA_ID_ROOT;
import static com.vpaliy.melophile.playback.MediaHelper.getHierarchy;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import javax.inject.Inject;

public class MusicPlaybackService extends MediaBrowserServiceCompat
        implements PlaybackManager.PlaybackServiceCallback,
        PlaybackManager.MetadataUpdateListener{

    private static final String TAG=MusicPlaybackService.class.getSimpleName();

    private MediaSessionCompat mediaSession;
    private TrackNotification notification;

    @Inject
    protected PlaybackManager playbackManager;

    @Inject
    protected PersonalRepository repository;

    public MusicPlaybackService(){
        App.appInstance().playerComponent().inject(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        playbackManager.setServiceCallback(this);
        playbackManager.setUpdateListener(this);
        mediaSession=new MediaSessionCompat(getApplicationContext(),TAG);
        mediaSession.setCallback(playbackManager.getMediaSessionCallback());
        mediaSession.setFlags(MediaSessionCompat.FLAG_HANDLES_MEDIA_BUTTONS |
                MediaSessionCompat.FLAG_HANDLES_TRANSPORT_CONTROLS);
        setSessionToken(mediaSession.getSessionToken());
        Context context = getApplicationContext();
        Intent intent = new Intent(context, TrackActivity.class);
        PendingIntent pi = PendingIntent.getActivity(context, 99,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);
        mediaSession.setSessionActivity(pi);
        notification=new TrackNotification(this);
        playbackManager.updatePlaybackState(PlaybackStateCompat.STATE_NONE);
    }

    @Override
    public int onStartCommand(Intent startIntent, int flags, int startId) {
        if (startIntent != null) {
            String action = startIntent.getAction();
            if(action!=null) {
                switch (action){
                    case MediaTasks.ACTION_STOP:
                        stopSelf();
                        break;
                    case MediaTasks.ACTION_START_WIDGET:
                        new AsyncTask<Void,Void,List<Track>>(){
                            @Override
                            protected List<Track> doInBackground(Void... params) {
                                return repository.fetchTrackHistory();
                            }

                            @Override
                            protected void onPostExecute(List<Track> tracks) {
                                super.onPostExecute(tracks);
                                startWidget(tracks);
                            }
                        }.execute();
                        break;
                    default:
                        MediaTasks.executeTask(playbackManager,action);
                        break;
                }
            }
            MediaButtonReceiver.handleIntent(mediaSession, startIntent);
        }
        return START_NOT_STICKY;
    }

    @Override
    public void onMetadataChanged(MediaMetadataCompat metadata) {
        mediaSession.setMetadata(metadata);
        notification.updateMetadata(metadata);
        notifyWidget(metadata);
    }

    @Override
    public void onMetadataRetrieveError() {

    }

    private void startWidget(List<Track> tracks){
        if(tracks!=null){
            playbackManager.setQueueManager(QueueManager.createQueue(tracks,0));
            playbackManager.handleResumeRequest();
        }
    }

    @Override
    public void onPlaybackStart() {
        mediaSession.setActive(true);
        Intent intent=new Intent(this,MusicPlaybackService.class);
        startService(intent);
    }

    private void notifyWidget(MediaMetadataCompat metadataCompat){
        if(metadataCompat!=null) {
            Intent intent = new Intent();
            intent.setAction(MediaTasks.ACTION_UPDATE);
            intent.putExtra(Constants.EXTRA_DATA,metadataCompat);
            sendBroadcast(intent);
        }
    }

    private void notifyWidget(PlaybackStateCompat stateCompat){
        if(stateCompat!=null){
            Intent intent=new Intent();
            intent.setAction(MediaTasks.ACTION_UPDATE);
            intent.putExtra(Constants.EXTRA_PLAYBACK_STATE,stateCompat);
            sendBroadcast(intent);
        }
    }

    @Override
    public void onPlaybackStop() {
        mediaSession.setActive(false);
        notification.pauseNotification();
    }

    @Override
    public void onPlaybackStateUpdated(PlaybackStateCompat stateCompat) {
        mediaSession.setPlaybackState(stateCompat);
        notification.updatePlaybackState(stateCompat);
        notifyWidget(stateCompat);
    }

    @Override
    public void onNotificationRequired() {
        notification.startNotification();
    }

    @Override
    public void onDestroy() {
        mediaSession.release();
        stopForeground(true);
        stopWidget();
        super.onDestroy();
    }

    private void stopWidget(){
        Intent intent=new Intent(MediaTasks.ACTION_STOP_WIDGET);
        sendBroadcast(intent);
    }

    @Nullable
    @Override
    public BrowserRoot onGetRoot(@NonNull String clientPackageName, int clientUid, @Nullable Bundle rootHints) {
        if(!clientPackageName.equals(getPackageName())){
            return new BrowserRoot(MEDIA_ID_ROOT,null);
        }
        return new BrowserRoot(MEDIA_ID_EMPTY_ROOT,null);
    }

    @Override
    public void onLoadChildren(@NonNull String parentId, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result) {}
}