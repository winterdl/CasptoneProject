package com.vpaliy.melophile.ui.user.info;

import android.os.Bundle;
import android.support.v4.content.Loader;
import com.vpaliy.domain.loader.GetUserFollowers;
import com.vpaliy.domain.model.User;
import java.util.List;
import com.vpaliy.melophile.di.scope.ViewScope;
import javax.inject.Inject;

@ViewScope
public class FollowersPresenter extends UserInfoPresenter<User> {

    private GetUserFollowers userFollowersUseCase;

    @Inject
    public FollowersPresenter(GetUserFollowers userFollowersUseCase){
        this.userFollowersUseCase=userFollowersUseCase;
    }

    @Override
    public void start(String id) {
        userFollowersUseCase.setParams(id);
        manager.initLoader(0,null,this);
    }

    @Override
    public Loader<List<User>> onCreateLoader(int id, Bundle args) {
        return userFollowersUseCase.setListener(this::catchError);
    }

    @Override
    public void stop() {
        manager.destroyLoader(0);
    }
}
