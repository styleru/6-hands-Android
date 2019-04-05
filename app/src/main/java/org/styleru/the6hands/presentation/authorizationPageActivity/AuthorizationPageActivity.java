package org.styleru.the6hands.presentation.authorizationPageActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.vk.api.sdk.VK;
import com.vk.api.sdk.auth.VKAccessToken;
import com.vk.api.sdk.auth.VKAuthCallback;

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
        authVK.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Auth", Toast.LENGTH_LONG).show();
            authViaVK(this);
        });
        skipAuth.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Skip", Toast.LENGTH_LONG).show();
            skipAuth();
        });
    }

    @Override
    public void authViaVK(AppCompatActivity appCompatActivity) {
        authViaVK(this);
        setResult(1, new Intent().putExtra("VK login", true));
        finish();
    }

    @Override
    public void skipAuth() {
        setResult(1, new Intent().putExtra("VK login", false));
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  //Обработка результата авторизации
        VKAuthCallback callback = new VKAuthCallback() {
            @Override
            public void onLogin(VKAccessToken vkAccessToken) {
                Log.d("VK AUTH", "Success");

//                Поставить функцию передачи токена в бд/презентер/интентом в родительское активити, переход к следующей активити
            }

            @Override
            public void onLoginFailed(int i) {
                Log.d("VK AUTH", "Fail");
            }
        };

        if(!VK.onActivityResult(requestCode, resultCode, data, callback)){
            super.onActivityResult(requestCode, resultCode, data);
        }

    }
}
