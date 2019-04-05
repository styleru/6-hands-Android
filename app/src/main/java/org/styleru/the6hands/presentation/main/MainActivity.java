package org.styleru.the6hands.presentation.main;

import android.content.Context;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.widget.Toast;

import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;


import org.styleru.the6hands.R;
import org.styleru.the6hands.Screens;
import org.styleru.the6hands.SixHandsApp;
import org.styleru.the6hands.presentation.map.MapFragment;
import org.styleru.the6hands.presentation.profile.ProfileFragment;

import ru.terrakok.cicerone.Navigator;


public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter presenter;


    private NavigatorHolder navigatorHolder;

    private Context context;

    private BottomNavigationView navigation;
    //Cicerone fragment creation
    private Navigator navigator = new SupportFragmentNavigator(getSupportFragmentManager(), R.id.fragment_container) {
        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            switch (screenKey) {
                case Screens.PROFILE_SCREEN:
                    return new ProfileFragment();
                case Screens.MAP_SCREEN:
                    return new MapFragment();
                default:
                    return null;
            }
        }

        @Override
        protected void showSystemMessage(String message) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void exit() {
            finish();
        }
    };

        private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
           return presenter.onNavClicked(item.getItemId());
        }
    };


    @Override
    public void onBackPressed() {
        if(presenter.isActiveScreenHome()) System.exit(1);
        else presenter.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigatorHolder = SixHandsApp.INSTANCE.getNavigatorHolder();
        presenter.initRouter();
        presenter.onCreateActivity();
        context = getApplicationContext();


        //BottomNavigationBar
        navigation =  findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



    }




    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        super.onPause();
        navigatorHolder.removeNavigator();
    }

    @Override
    public void makeText(){
        Toast.makeText(context,"Здесь пока ничего нет",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setChecked(String key) {
        switch (key){
            case (Screens.DIALOGS_SCREEN):
                navigation.getMenu().findItem(R.id.nav_dialogs).setChecked(true);
            case (Screens.LIST_SCREEN):
                navigation.getMenu().findItem(R.id.nav_list).setChecked(true);
            case (Screens.MAP_SCREEN):
                navigation.getMenu().findItem(R.id.nav_map).setChecked(true);
            case (Screens.PROFILE_SCREEN):
                navigation.getMenu().findItem(R.id.nav_profile).setChecked(true);
        }
    }


}
