package org.styleru.the6hands.presentation.main;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import org.styleru.the6hands.R;
import org.styleru.the6hands.Screens;
import org.styleru.the6hands.SixHandsApp;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private Router router;
    private String activeScreen;

    public void initRouter(){
        router = SixHandsApp.INSTANCE.getRouter();
    }

    public boolean isActiveScreenHome(){
        return activeScreen.equals(Screens.PROFILE_SCREEN);
    }

    public void onBackPressed(){
        router.navigateTo(Screens.PROFILE_SCREEN);
        activeScreen = Screens.PROFILE_SCREEN;
        getViewState().setChecked(Screens.PROFILE_SCREEN);
    }


    public boolean onNavClicked(int id){
        switch (id) {
            case R.id.nav_list:
                getViewState().makeText();
                return true;
            case R.id.nav_map:
                router.navigateTo(Screens.MAP_SCREEN);
                activeScreen = Screens.MAP_SCREEN;
                return true;
            case R.id.nav_dialogs:
                getViewState().makeText();
                return true;
            case R.id.nav_profile:
               router.navigateTo(Screens.PROFILE_SCREEN);
               activeScreen = Screens.PROFILE_SCREEN;
                return true;
        }
        return false;
    }

    public void onCreateActivity(){
        router.navigateTo(Screens.PROFILE_SCREEN);
        activeScreen = Screens.PROFILE_SCREEN;
        getViewState().setChecked(Screens.PROFILE_SCREEN);
    }


}
