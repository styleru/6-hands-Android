package org.styleru.the6hands.presentation.main;

import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.arellomobile.mvp.MvpAppCompatActivity;

import org.styleru.the6hands.R;
import org.styleru.the6hands.presentation.profile.ProfileFragment;

public class MainActivity extends MvpAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ProfileFragment profileFragment = new ProfileFragment();
        fragmentTransaction.add(R.id.fragment_container,profileFragment);
        fragmentTransaction.commit();

    }
}
