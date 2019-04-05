package org.styleru.the6hands.presentation.main;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vk.api.sdk.VK;
import com.vk.api.sdk.VKTokenExpiredHandler;

import org.styleru.the6hands.R;
import org.styleru.the6hands.presentation.authorizationPageActivity.AuthorizationPageActivity;
import org.styleru.the6hands.di.App;
import org.styleru.the6hands.presentation.profile.ProfileFragment;

public class MainActivity extends AppCompatActivity implements MainActivityView{

    private BottomNavigationView bottomNavigationView;
    private ProfileFragment profileFragment;

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
            startActivityForResult(new Intent(this, AuthorizationPageActivity.class), 1);
        }

        setupNavigationBar();
    }

    void setupNavigationBar() {
      //  bottomNavigationView.setOnNavigationItemSelectedListener();

    }
}

