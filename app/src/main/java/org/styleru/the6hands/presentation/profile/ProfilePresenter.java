package org.styleru.the6hands.presentation.profile;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import org.styleru.the6hands.domain.interactor.ApartmentInteractor;

import javax.inject.Inject;

@InjectViewState
public class ProfilePresenter extends MvpPresenter<ProfileFragmentView> {

    private ApartmentInteractor interactor;

    @Inject
    ProfilePresenter(ApartmentInteractor apartmentInteractor) {
        this.interactor = apartmentInteractor;
    }

    public void showUserName() {

    }
    public void showAvatar() {

    }
    public void showApartments() {

    }
    public void changeUserData() {

    }
    public void rentApartment() {

    }
    public void shareViaVk() {

    }
    public void shareViaFacebook() {

    }
}
