package org.styleru.the6hands.di;

import android.content.Context;

import org.styleru.the6hands.di.module.NavigationModule;
import org.styleru.the6hands.di.module.RepositoryModule;
import org.styleru.the6hands.presentation.authorizationPageActivity.AuthorizationPageActivity;
import org.styleru.the6hands.presentation.main.MainActivity;
import org.styleru.the6hands.presentation.profile.ProfileFragment;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {RepositoryModule.class, NavigationModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);
    void inject(ProfileFragment profileFragment);
    void inject(AuthorizationPageActivity authorizationPageActivity);

    @Component.Builder
    interface Builder {
        AppComponent build();

        @BindsInstance
        Builder context(Context context);
    }

}