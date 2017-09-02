package com.vpaliy.domain.loader;

import android.content.Context;
import android.text.TextUtils;

import com.vpaliy.domain.model.UserDetails;
import com.vpaliy.domain.repository.Repository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GetUserDetails extends SingleLoader<UserDetails,String> {

    private Repository repository;

    @Inject
    public GetUserDetails(Context context, Repository repository){
        super(context);
        this.repository=repository;
    }

    @Override
    public UserDetails load() {
        if(!TextUtils.isEmpty(params)){
            return repository.getUserBy(params);
        }
        throw new IllegalArgumentException("Id is null!");
    }
}
