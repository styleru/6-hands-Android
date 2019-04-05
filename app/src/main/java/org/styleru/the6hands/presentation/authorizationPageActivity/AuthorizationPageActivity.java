package org.styleru.the6hands.presentation.authorizationPageActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import org.styleru.the6hands.R;
import org.styleru.the6hands.di.App;

import javax.inject.Inject;

public class AuthorizationPageActivity extends MvpAppCompatActivity implements AuthorizationPageView {

    @Inject
    @InjectPresenter
    AuthorizationPagePresenter authorizationPagePresenter;

    @ProvidePresenter
    AuthorizationPagePresenter provideAuthorizationPagePresenter(){
        return this.authorizationPagePresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        App.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        Button authVK = findViewById(R.id.VK_authorization_button);
        Button skipAuth = findViewById(R.id.skip_button);
        authVK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Auth", Toast.LENGTH_LONG).show();
            }
        });
        authVK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Skip", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void authViaVK() {

    }

    @Override
    public void skipAuth() {

    }
}
