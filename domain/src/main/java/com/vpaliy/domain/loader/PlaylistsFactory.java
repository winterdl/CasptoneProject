package com.vpaliy.domain.loader;

import android.content.Context;
import com.vpaliy.domain.model.MelophileTheme;
import com.vpaliy.domain.repository.Repository;
import java.util.Arrays;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PlaylistsFactory extends ThemeFactory<GetPlaylists>{

    @Inject
    public PlaylistsFactory(Context context, Repository repository){
        super(context,repository);
    }

    @Override
    protected void initThemes(){
        themes= Arrays.asList(MelophileTheme.create("Good Morning","Good Morning", "2017","Morning","Coffee","Tea","Paris"),
                MelophileTheme.create("Sleeping","Dream","travel","road"),
                MelophileTheme.create("Relaxing","relax","relaxing","chills"),
                MelophileTheme.create("Chilling","chills","party","friends"),
                MelophileTheme.create("Working out","working out","sweet","moment"));
    }

    public GetPlaylists forTheme(int themeIndex){
        if(themeIndex<0||themeIndex>=themes.size()) {
            return null;
        }
        GetPlaylists getPlaylists=new GetPlaylists(context,repository);
        getPlaylists.setParams(themes.get(themeIndex));
        return getPlaylists;
    }
}
