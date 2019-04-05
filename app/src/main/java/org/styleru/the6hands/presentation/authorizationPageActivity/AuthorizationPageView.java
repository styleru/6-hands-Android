package org.styleru.the6hands.presentation.authorizationPageActivity;

import android.support.v7.app.AppCompatActivity;

import com.arellomobile.mvp.MvpView;

public interface AuthorizationPageView extends MvpView {

    void authViaVK(AppCompatActivity appCompatActivity);

    void skipAuth();

}
