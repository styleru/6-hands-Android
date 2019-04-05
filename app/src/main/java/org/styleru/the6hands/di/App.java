package org.styleru.the6hands.di;

import android.app.Application;

public class App extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                .context(this)
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
