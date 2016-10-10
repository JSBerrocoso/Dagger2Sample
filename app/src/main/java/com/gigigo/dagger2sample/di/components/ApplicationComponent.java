package com.gigigo.dagger2sample.di.components;

import android.content.Context;
import com.gigigo.dagger2sample.di.modules.ApplicationModule;
import com.gigigo.dagger2sample.di.modules.InteractorModule;
import com.gigigo.dagger2sample.domain.interactors.ArtistSearchInteractor;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by santiago.berrocoso on 04/10/16.
 */
@Singleton @Component(modules = {
    ApplicationModule.class, InteractorModule.class
}) public interface ApplicationComponent {

  Context getContext();

  ArtistSearchInteractor getArtistSearchInteractor();
}
