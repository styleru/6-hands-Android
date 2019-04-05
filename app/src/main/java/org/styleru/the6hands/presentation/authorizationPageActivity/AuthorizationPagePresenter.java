package org.styleru.the6hands.presentation.authorizationPageActivity;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import org.styleru.the6hands.domain.interactor.AuthorizationPageInteractor;

import javax.inject.Inject;

@InjectViewState
public class AuthorizationPagePresenter extends MvpPresenter<AuthorizationPageView> {

    private AuthorizationPageInteractor authorizationPageInteractor;

    @Inject
    AuthorizationPagePresenter(AuthorizationPageInteractor authorizationPageInteractor) {
        this.authorizationPageInteractor = authorizationPageInteractor;
    }

    public void authVK(){}

    public void recieveToken(){}

    public void skipAuth(){}

}
