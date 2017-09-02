package com.vpaliy.melophile.di.component;

import com.vpaliy.domain.repository.Repository;
import com.vpaliy.melophile.di.module.PlaybackModule;
import com.vpaliy.melophile.playback.PlaybackManager;
import com.vpaliy.melophile.playback.service.MusicPlaybackService;
import dagger.Component;
import com.vpaliy.domain.playback.PlayerScope;
import com.vpaliy.melophile.ui.track.TrackFragment;
import com.vpaliy.melophile.widget.MusicWidget;

@PlayerScope
@Component(modules = PlaybackModule.class,
        dependencies = ApplicationComponent.class)
public interface PlayerComponent {
    void inject(MusicPlaybackService service);
    void inject(TrackFragment fragment);
    void inject(MusicWidget widget);
}
