package com.vpaliy.domain.loader;

import android.content.Context;

import com.vpaliy.domain.model.User;
import com.vpaliy.domain.repository.PersonalRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GetMe extends SingleLoader<User,Void> {

    private PersonalRepository repository;

    @Inject
    public GetMe(Context context, PersonalRepository repository){
        super(context);
        this.repository=repository;
    }

    @Override
    public User load() {
        return repository.fetchMe();
    }
}
