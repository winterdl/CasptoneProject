package com.vpaliy.domain.loader;

import android.content.Context;
import android.text.TextUtils;

import com.vpaliy.domain.model.User;
import com.vpaliy.domain.repository.Repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GetUserFollowers extends SingleLoader<List<User>,String> {

    private Repository repository;

    @Inject
    public GetUserFollowers(Context context, Repository repository){
        super(context);
        this.repository=repository;
    }

    @Override
    public List<User> load() {
        if(!TextUtils.isEmpty(params)){
            return repository.getUserFollowers(params);
        }
        throw new IllegalArgumentException("Id is null");
    }
}
