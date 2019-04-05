package org.styleru.the6hands;

import android.app.Application;

import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

public class SixHandsApp extends Application {

    public static SixHandsApp INSTANCE;
    private Cicerone<Router> cicerone;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        cicerone = Cicerone.create();
    }

    public NavigatorHolder getNavigatorHolder(){
        return cicerone.getNavigatorHolder();
    }

    public Router getRouter(){
        return cicerone.getRouter();
    }
}
