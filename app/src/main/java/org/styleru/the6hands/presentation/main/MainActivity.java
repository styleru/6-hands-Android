package org.styleru.the6hands.presentation.main;

import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.styleru.the6hands.R;
import org.styleru.the6hands.presentation.di.App;
import org.styleru.the6hands.presentation.profile.ProfileFragment;

import ru.terrakok.cicerone.commands.Command;

public class MainActivity extends AppCompatActivity implements MainActivityView{

    private BottomNavigationView bottomNavigationView;
    private ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        App.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupNavigationBar();
    }

    void setupNavigationBar() {
      //  bottomNavigationView.setOnNavigationItemSelectedListener();

    }
}

