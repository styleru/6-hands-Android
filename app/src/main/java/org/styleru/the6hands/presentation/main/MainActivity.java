package org.styleru.the6hands.presentation.main;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vk.api.sdk.VK;
import com.vk.api.sdk.VKTokenExpiredHandler;

import org.styleru.the6hands.R;
import org.styleru.the6hands.di.App;
import org.styleru.the6hands.presentation.authorizationPageActivity.AuthorizationPageActivity;
import org.styleru.the6hands.presentation.di.App;
import org.styleru.the6hands.presentation.profile.ProfileFragment;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

import static org.styleru.the6hands.presentation.Screens.PROFILE_SCREEN;

public class MainActivity extends AppCompatActivity implements MainActivityView{

    @Inject
    NavigatorHolder navigatorHolder;
    @Inject
    Router router;

    private BottomNavigationView bottomNavigationView;
    private ProfileFragment profileFragment;

    private Navigator navigator= new SupportFragmentNavigator(getSupportFragmentManager(), R.id.fragment_container) {

        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            switch (screenKey) {
                case PROFILE_SCREEN:
                    //return ProfileFragment.getNewInstance(data);
                default:
                    throw new RuntimeException("Unknown screen key!");
            }
        }

        @Override
        protected void showSystemMessage(String message) {

        }

        @Override
        protected void exit() {
            finish();
        }
    };

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        App.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VK.initialize(this);

        VKTokenExpiredHandler vkTokenExpiredHandler = () -> {
            if(!VK.isLoggedIn()) startActivityForResult(new Intent(this,
                    AuthorizationPageActivity.class), 1);
        };

        VK.addTokenExpiredHandler(vkTokenExpiredHandler);

        if(!VK.isLoggedIn()){
            startActivityForResult(new Intent(this, AuthorizationPageActivity.class), 1)
        }

        setupNavigationBar();
    }

    void setupNavigationBar() {
      //  bottomNavigationView.setOnNavigationItemSelectedListener();

    }

    @Override
    protected void onResume() {
        navigatorHolder.setNavigator(navigator);
        super.onResume();
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }
}

