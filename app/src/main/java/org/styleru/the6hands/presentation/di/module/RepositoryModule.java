package org.styleru.the6hands.presentation.di.module;

import org.styleru.the6hands.presentation.data.RepositoryImpl;
import org.styleru.the6hands.presentation.domain.repository.Repository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    Repository provideRepository() {
        return new RepositoryImpl();
    }
}
