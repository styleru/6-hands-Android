package org.styleru.the6hands.presentation.AuthorizationActivity;

import com.arellomobile.mvp.InjectViewState;

import org.styleru.the6hands.domain.AuthorizationPageInteractor;

import javax.inject.Inject;

@InjectViewState
public class AuthorizationPagePresenter {

    private AuthorizationPageInteractor authorizationPageInteractor;

    @Inject
    AuthorizationPagePresenter(AuthorizationPageInteractor authorizationPageInteractor) {
        this.authorizationPageInteractor = authorizationPageInteractor;
    }

    public void authVK(){}

    public void recieveToken(){}

    public void skipAuth(){}

}
