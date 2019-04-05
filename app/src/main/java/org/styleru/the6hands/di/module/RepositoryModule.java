package org.styleru.the6hands.di.module;

import org.styleru.the6hands.data.RepositoryImpl;
import org.styleru.the6hands.domain.repository.Repository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    Repository provideRepository() {
        return new RepositoryImpl();
    }
}
