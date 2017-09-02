package com.vpaliy.melophile.di.module;

import com.vpaliy.domain.interactor.FollowUser;
import com.vpaliy.domain.loader.GetMe;
import com.vpaliy.domain.loader.PlaylistHistory;
import com.vpaliy.domain.loader.TrackHistory;
import com.vpaliy.domain.loader.GetPlaylist;
import com.vpaliy.domain.loader.GetPlaylists;
import com.vpaliy.domain.loader.GetTracks;
import com.vpaliy.domain.loader.GetUserDetails;
import com.vpaliy.domain.loader.GetUserFavorites;
import com.vpaliy.domain.loader.GetUserFollowers;
import com.vpaliy.domain.interactor.PlaylistSearch;
import com.vpaliy.domain.interactor.SaveInteractor;
import com.vpaliy.domain.interactor.TrackSearch;
import com.vpaliy.domain.interactor.UserSearch;
import com.vpaliy.domain.loader.PlaylistsFactory;
import com.vpaliy.domain.loader.ThemeFactory;
import com.vpaliy.domain.model.Track;
import com.vpaliy.domain.model.User;
import com.vpaliy.melophile.ui.personal.PersonalContract;
import com.vpaliy.melophile.ui.personal.PersonalPresenter;
import com.vpaliy.melophile.ui.playlist.PlaylistContract;
import com.vpaliy.melophile.ui.playlist.PlaylistPresenter;
import com.vpaliy.melophile.ui.playlists.PlaylistsContract;
import com.vpaliy.melophile.ui.playlists.PlaylistsPresenter;
import com.vpaliy.melophile.ui.search.SearchContract;
import com.vpaliy.melophile.ui.search.SearchPresenter;
import com.vpaliy.melophile.ui.tracks.TracksContract;
import com.vpaliy.melophile.ui.tracks.TracksPresenter;
import com.vpaliy.melophile.ui.user.PersonContract;
import com.vpaliy.melophile.ui.user.PersonPresenter;
import com.vpaliy.melophile.ui.user.info.FavoritePresenter;
import com.vpaliy.melophile.ui.user.info.FollowersPresenter;
import com.vpaliy.melophile.ui.user.info.UserInfoContract;
import com.vpaliy.melophile.di.scope.ViewScope;
import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {
    @ViewScope @Provides
    PlaylistsContract.Presenter playlists(ThemeFactory<GetPlaylists> playlistsThemeFactory){
        return new PlaylistsPresenter(playlistsThemeFactory);
    }

    @ViewScope @Provides
    TracksContract.Presenter tracks(ThemeFactory<GetTracks> tracksThemeFactory){
        return new TracksPresenter(tracksThemeFactory);
    }

    @ViewScope @Provides
    PlaylistContract.Presenter playlist(GetPlaylist getPlaylist, SaveInteractor saveInteractor){
        return new PlaylistPresenter(getPlaylist,saveInteractor);
    }

    @ViewScope @Provides
    PersonContract.Presenter person(GetUserDetails getUserDetails, FollowUser followUser){
        return new PersonPresenter(getUserDetails,followUser);
    }

    @ViewScope @Provides
    UserInfoContract.Presenter<User> followers(GetUserFollowers getUserFollowers){
        return new FollowersPresenter(getUserFollowers);
    }

    @ViewScope @Provides
    UserInfoContract.Presenter<Track> favorites(GetUserFavorites getUserFavorites){
        return new FavoritePresenter(getUserFavorites);
    }

    @ViewScope @Provides
    SearchContract.Presenter search(TrackSearch trackSearch, UserSearch userSearch, PlaylistSearch playlistSearch){
        return new SearchPresenter(trackSearch,playlistSearch,userSearch);
    }

    @ViewScope @Provides
    PersonalContract.Presenter personal(PlaylistHistory playlistHistory, TrackHistory trackHistory, GetMe getMe){
        return new PersonalPresenter(trackHistory, playlistHistory,getMe);
    }
}
