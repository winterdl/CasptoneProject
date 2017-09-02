package com.vpaliy.melophile.di.component;

import com.vpaliy.melophile.di.module.PlaybackModule;
import com.vpaliy.melophile.playback.service.MusicPlaybackService;
import com.vpaliy.melophile.ui.track.TrackFragment;
import com.vpaliy.melophile.widget.MusicWidget;
import dagger.Component;
import com.vpaliy.domain.playback.PlayerScope;

@PlayerScope
@Component(modules = PlaybackModule.class,
        dependencies = ApplicationComponent.class)
public interface PlayerComponent {
    void inject(MusicPlaybackService service);
    void inject(TrackFragment fragment);
    void inject(MusicWidget widget);
}
