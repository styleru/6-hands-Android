package org.styleru.the6hands.di;

import android.content.Context;

import org.styleru.the6hands.presentation.AuthorizationActivity.AuthorizationPageActivity;
import javax.inject.Singleton;
import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component
public interface AppComponent {

    void inject(AuthorizationPageActivity authorizationPageActivity);

    @Component.Builder
    interface Builder {
        AppComponent build();

        @BindsInstance
        Builder context(Context context);
    }

}
