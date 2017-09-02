package com.vpaliy.melophile.di.module;

import android.content.Context;

import com.vpaliy.domain.executor.BaseSchedulerProvider;
import com.vpaliy.domain.interactor.FollowUser;
import com.vpaliy.domain.loader.GetMe;
import com.vpaliy.domain.loader.PlaylistHistory;
import com.vpaliy.domain.loader.TrackHistory;
import com.vpaliy.domain.interactor.LoveTrack;
import com.vpaliy.domain.interactor.PlaylistSearch;
import com.vpaliy.domain.interactor.SaveInteractor;
import com.vpaliy.domain.interactor.TrackSearch;
import com.vpaliy.domain.interactor.UserSearch;
import com.vpaliy.domain.loader.GetPlaylist;
import com.vpaliy.domain.loader.GetPlaylists;
import com.vpaliy.domain.loader.GetTrack;
import com.vpaliy.domain.loader.GetTracks;
import com.vpaliy.domain.loader.GetUserDetails;
import com.vpaliy.domain.loader.GetUserFavorites;
import com.vpaliy.domain.loader.GetUserFollowers;
import com.vpaliy.domain.loader.PlaylistsFactory;
import com.vpaliy.domain.loader.ThemeFactory;
import com.vpaliy.domain.loader.TracksFactory;
import com.vpaliy.domain.repository.Repository;
import com.vpaliy.domain.repository.PersonalRepository;
import com.vpaliy.domain.repository.SearchRepository;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

//TODO are you sure they should live all the time???

@Module
public class InteractorModule {

    @Singleton @Provides
    GetPlaylists getPlaylists(Context context, Repository repository){
        return new GetPlaylists(context,repository);
    }

    @Singleton @Provides
    GetTracks getTracks(Context context, Repository repository){
        return new GetTracks(context,repository);
    }

    @Singleton @Provides
    GetTrack getTrack(Context context, Repository repository){
        return new GetTrack(context,repository);
    }

    @Singleton @Provides
    GetPlaylist getPlaylist(Context context, Repository repository){
        return new GetPlaylist(context,repository);
    }

    @Singleton @Provides
    GetUserDetails getUserDetails(Context context, Repository repository){
        return new GetUserDetails(context,repository);
    }

    @Singleton @Provides
    GetUserFollowers getUserFollowers(Context context, Repository repository){
        return new GetUserFollowers(context,repository);
    }

    @Singleton @Provides
    GetUserFavorites getUserFavorites(Context context, Repository repository){
        return new GetUserFavorites(context,repository);
    }

    @Singleton @Provides
    TrackSearch trackSearch(BaseSchedulerProvider schedulerProvider, SearchRepository repository){
        return new TrackSearch(schedulerProvider,repository);
    }

    @Singleton @Provides
    UserSearch userSearch(BaseSchedulerProvider schedulerProvider,SearchRepository repository){
        return new UserSearch(schedulerProvider,repository);
    }

    @Singleton @Provides
    PlaylistSearch playlistSearch(BaseSchedulerProvider schedulerProvider, SearchRepository repository){
        return new PlaylistSearch(schedulerProvider,repository);
    }

    @Singleton @Provides
    PlaylistHistory recentPlaylists(Context context, PersonalRepository repository){
        return new PlaylistHistory(context,repository);
    }

    @Singleton @Provides
    TrackHistory recentTracks(Context context, PersonalRepository repository){
        return new TrackHistory(context,repository);
    }

    @Singleton @Provides
    FollowUser follow(BaseSchedulerProvider schedulerProvider, PersonalRepository personalRepository){
        return new FollowUser(schedulerProvider,personalRepository);
    }

    @Singleton @Provides
    LoveTrack loveTrack(BaseSchedulerProvider schedulerProvider, PersonalRepository repository){
        return new LoveTrack(schedulerProvider,repository);
    }

    @Singleton @Provides
    SaveInteractor saveInteractor(PersonalRepository repository){
        return new SaveInteractor(repository);
    }

    @Singleton @Provides
    GetMe me(Context context, PersonalRepository repository){
        return new GetMe(context,repository);
    }

    @Singleton @Provides
    ThemeFactory<GetPlaylists> playlistsFactory(Context context, Repository repository){
        return new PlaylistsFactory(context,repository);
    }

    @Singleton @Provides
    ThemeFactory<GetTracks> tracksFactory(Context context, Repository repository){
        return new TracksFactory(context,repository);
    }
}
