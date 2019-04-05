package org.styleru.the6hands.domain.interactor;

import org.styleru.the6hands.domain.repository.Repository;

import javax.inject.Inject;

public class MainActivityInteractor {

    private Repository repository;

    @Inject
    MainActivityInteractor(Repository repository) {
        this.repository = repository;
    }

}
