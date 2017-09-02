package com.vpaliy.melophile.ui.user;

import com.vpaliy.domain.interactor.FollowUser;
import com.vpaliy.domain.loader.GetUserDetails;
import com.vpaliy.domain.model.User;
import com.vpaliy.domain.model.UserDetails;
import java.util.List;
import android.support.v4.app.LoaderManager;
import static com.vpaliy.melophile.ui.user.PersonContract.View;
import static dagger.internal.Preconditions.checkNotNull;
import android.util.Log;
import com.vpaliy.melophile.ui.base.LoaderCallback;
import android.support.annotation.NonNull;
import com.vpaliy.melophile.di.scope.ViewScope;
import javax.inject.Inject;

@ViewScope
public class PersonPresenter implements PersonContract.Presenter{

    private View view;
    private LoaderManager manager;
    private FollowUser followUserUseCase;
    private User user;
    private LoaderCallback<UserDetails,String> detailsLoader;

    @Inject
    public PersonPresenter(GetUserDetails userDetailsUseCase, FollowUser followUserUseCase){
        this.detailsLoader=new LoaderCallback<>(userDetailsUseCase,this::catchData)
                .setError(this::catchError);
        this.followUserUseCase=followUserUseCase;
    }

    @Override
    public void attachView(@NonNull View view) {
        this.view=checkNotNull(view);
    }

    @Override
    public void start(String id) {
        view.showLoading();
        detailsLoader.setParams(id);
        manager.initLoader(0, null, detailsLoader);
    }

    private void catchData(UserDetails details){
        view.hideLoading();
        if(details!=null){
            boolean isEmpty=isEmpty(details.getTracks());
            if(!isEmpty) {
                view.showTracks(details.getTracks());
            }
            //check the playlists
            if(!isEmpty(details.getPlaylists())) {
                view.showPlaylists(details.getPlaylists());
            }else if(isEmpty){
                view.showEmptyMediaMessage();
            }
            Log.d(PersonPresenter.class.getSimpleName(),Boolean.toString(isEmpty));
            user=details.getUser();
            if(user!=null){
                view.showFollowersCount(user.getFollowersCount());
                view.showTitle(user.getNickName());
                view.showDescription(user.getDescription());
                view.showTracksCount(user.getTracksCount());
                view.showLikedCount(user.getLikedTracksCount());
                manageFollowing();
            }
        }else{
            view.showEmptyMessage();
        }
    }

    private <T> boolean isEmpty(List<T> items){
        return items==null||items.isEmpty();
    }

    private void catchError(Throwable ex){
        view.hideLoading();
        ex.printStackTrace();
        view.showErrorMessage();
    }

    private void manageFollowing(){
        if(user.isFollowed()){
            view.disableFollow();
        }else{
            view.enableFollow();
        }
    }

    @Override
    public void follow() {
        if(user!=null) {
            if(!user.isFollowed()) {
                followUserUseCase.execute(this::catchFollowRequest,
                        this::catchError, user);
            }else{
                followUserUseCase.execute2(this::catchFollowRequest,
                        this::catchError,user);
            }
        }
    }

    private void catchFollowRequest(){
        user.setFollowed(!user.isFollowed());
        manageFollowing();
    }

    @Override
    public void attachManager(@NonNull LoaderManager loaderManager) {
        this.manager=checkNotNull(loaderManager);
    }

    @Override
    public void stop() {
        manager.destroyLoader(0);
    }
}
