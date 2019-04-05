package org.styleru.the6hands.domain.interactor;


import org.styleru.the6hands.domain.repository.Repository;

import javax.inject.Inject;

public class ApartmentInteractor {

    private Repository repository;

    @Inject
    ApartmentInteractor(Repository repository) {
        this.repository = repository;
    }
}
