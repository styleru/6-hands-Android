package org.styleru.the6hands.dagger;


import org.styleru.the6hands.presentation.apartmentscreen.ApartmentFragment;
import org.styleru.the6hands.presentation.authscreen.AuthActivity;
import org.styleru.the6hands.presentation.mainscreen.MainActivity;
import org.styleru.the6hands.presentation.profile.ProfileFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NavigationModule.class, RepositoryModule.class, NetworkModule.class})
public interface AppComponent {

    void inject(AuthActivity authActivity);
    void inject(MainActivity mainActivity);
    void inject(ProfileFragment profileFragment);
    void inject(ApartmentFragment apartmentFragment);

    @Component.Builder
    interface Builder {
        AppComponent build();

    }
}
