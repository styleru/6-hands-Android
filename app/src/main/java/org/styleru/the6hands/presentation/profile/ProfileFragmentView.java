package org.styleru.the6hands.presentation.profile;

import com.arellomobile.mvp.MvpView;

public interface ProfileFragmentView extends MvpView {
    void showUserName();
    void showAvatar();
    void showApartments();
}