package org.styleru.the6hands;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.vk.api.sdk.VK;
import com.vk.api.sdk.VKTokenExpiredHandler;
import com.vk.api.sdk.auth.VKAccessToken;
import com.vk.api.sdk.auth.VKAuthCallback;

public class VKAuth extends AppCompatActivity{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        VK.initialize(this);
        super.onCreate(savedInstanceState);



        VKTokenExpiredHandler vkTokenExpiredHandler = new VKTokenExpiredHandler() { //      Обрабатывает ситуации с невалидным токеном
            @Override
            public void onTokenExpired() {
                if(!VK.isLoggedIn()) VK.login(getParent());
            }
        };
        VK.addTokenExpiredHandler(vkTokenExpiredHandler);
        if(!VK.isLoggedIn()){
            VK.login(this);
        }
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