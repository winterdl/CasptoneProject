package com.vpaliy.data.source;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import com.vpaliy.data.mapper.Mapper;
import com.vpaliy.data.source.local.handler.TrackHandler;
import com.vpaliy.data.source.local.handler.UserHandler;
import com.vpaliy.domain.model.Track;
import com.vpaliy.domain.model.User;
import com.vpaliy.soundcloud.SoundCloudService;
import com.vpaliy.soundcloud.model.TrackEntity;
import com.vpaliy.soundcloud.model.UserEntity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PersonalInfo {

    private Set<String> likedIds;
    private Set<String> followedIds;

    @Inject
    public PersonalInfo(Context context, SoundCloudService service,
                        Mapper<Track,TrackEntity> trackMapper,
                        Mapper<User,UserEntity> userMapper,
                        TrackHandler trackHandler,
                        UserHandler userHandler){
        likedIds=new HashSet<>();
        followedIds=new HashSet<>();
        boolean isConnection=isNetworkConnection(context);
        fetchFollowings(service,userMapper,userHandler,isConnection);
        fetchTracks(service,trackMapper,trackHandler,isConnection);
    }

    private void fetchFollowings(SoundCloudService service, Mapper<User,UserEntity> mapper,
                                 UserHandler userHandler, boolean isConnection){
        if(isConnection) {
            service.fetchMyFollowings()
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.computation())
                    .subscribe(page -> {
                        if (page != null) {
                            if (page.collection != null) {
                                fetchFollowings(mapper.map(page.collection));
                                for (UserEntity entity : page.collection) {
                                    userHandler.insert(mapper.map(entity));
                                }
                            }
                        }
                    });
        }else{
            new AsyncTask<Void,Void,Void>(){
                @Override
                protected Void doInBackground(Void... params) {
                    fetchFollowings(userHandler.queryFollowings());
                    return null;
                }
            }.execute();
        }
    }

    private void fetchTracks(SoundCloudService service, Mapper<Track,TrackEntity> mapper,
                             TrackHandler handler, boolean isConnection){
        if(isConnection) {
            service.fetchMyFavoriteTracks()
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.computation())
                    .subscribe(list -> {
                        if (list != null) {
                            fetchTracks(mapper.map(list));
                            for (TrackEntity entity : list) {
                                handler.insert(mapper.map(entity));
                            }
                        }
                    });
        }else{
            new AsyncTask<Void,Void,Void>(){
                @Override
                protected Void doInBackground(Void... params) {
                    fetchTracks(handler.queryLiked());
                    return null;
                }
            }.execute();
        }
    }

    private void fetchFollowings(List<User> list){
        if(list!=null){
            if(!list.isEmpty()){
                for(User entity:list) {
                    followedIds.add(entity.getId());
                }
            }
        }
    }

    private void fetchTracks(List<Track> list){
        if(list!=null) {
            if (!list.isEmpty()) {
                for (Track entity:list) {
                    likedIds.add(entity.getId());
                }
            }
        }
    }

    public boolean amFollowing(String id){
        return followedIds.contains(id);
    }

    public boolean didLike(String id){
        return likedIds.contains(id);
    }

    public User amFollowing(User user){
        if(user!=null){
            user.setFollowed(followedIds.contains(user.getId()));
        }
        return user;
    }

    public List<User> amFollowing(List<User> userList){
        if(userList!=null){
            for(User user:userList) {
                amFollowing(user);
            }
        }
        return userList;
    }

    public List<Track> didLike(List<Track> tracks){
        if(tracks!=null){
            for(Track track:tracks){
                didLike(track);
            }
        }
        return tracks;
    }

    public Track didLike(Track track){
        if(track!=null){
            track.setLiked(likedIds.contains(track.getId()));
        }
        return track;
    }

    private boolean isNetworkConnection(Context context){
        ConnectivityManager manager=ConnectivityManager.class
                .cast(context.getSystemService(Context.CONNECTIVITY_SERVICE));
        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
        return activeNetwork!=null && activeNetwork.isConnectedOrConnecting();
    }

    public void removeFollower(String id){
        followedIds.remove(id);
    }

    public void removeLiked(String id){
        likedIds.remove(id);
    }

    public void follow(String id){
        followedIds.add(id);
    }

    public void like(String id){
        likedIds.add(id);
    }
}
