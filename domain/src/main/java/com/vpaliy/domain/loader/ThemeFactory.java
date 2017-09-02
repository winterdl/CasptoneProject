package com.vpaliy.domain.loader;

import android.content.Context;
import com.vpaliy.domain.model.MelophileTheme;
import com.vpaliy.domain.repository.Repository;

import java.util.List;


@SuppressWarnings("WeakerAccess")
public abstract class ThemeFactory<T> {

    protected Context context;
    protected Repository repository;
    protected List<MelophileTheme> themes;

    public ThemeFactory(Context context, Repository repository){
        this.context=context;
        this.repository=repository;
        initThemes();
    }

    protected abstract void initThemes();
    public abstract T forTheme(int themeIndex);

    public int themesCount(){
        return themes.size();
    }
}