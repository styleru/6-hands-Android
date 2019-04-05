package org.styleru.the6hands.presentation.domain.interactor;


import org.styleru.the6hands.presentation.domain.repository.Repository;

import javax.inject.Inject;

public class ApartmentInteractor {

    private Repository repository;

    @Inject
    ApartmentInteractor(Repository repository) {
        this.repository = repository;
    }
}
