package com.vpaliy.domain.loader;

import android.content.Context;
import com.vpaliy.domain.model.MelophileTheme;
import com.vpaliy.domain.repository.Repository;
import java.util.Arrays;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TracksFactory extends ThemeFactory<GetTracks> {

    @Inject
    public TracksFactory(Context context, Repository repository){
        super(context,repository);
    }

    @Override
    protected void initThemes() {
        themes= Arrays.asList(MelophileTheme.create("Top50","top50","best"),
                MelophileTheme.create("Sleeping","Dream","travel","road"),
                MelophileTheme.create("Relaxing","relax","relaxing","chills"),
                MelophileTheme.create("Chilling","chills","party","friends"),
                MelophileTheme.create("Working out","working out","sweet","moment"));
    }

    @Override
    public GetTracks forTheme(int themeIndex) {
        if(themeIndex<0||themeIndex>=themes.size()) {
            return null;
        }
        GetTracks getTracks=new GetTracks(context,repository);
        getTracks.setParams(themes.get(themeIndex));
        return getTracks;
    }
}
