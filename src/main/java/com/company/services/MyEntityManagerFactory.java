package com.company.services;

import com.company.common.base.binding.MySQL;
import com.company.common.base.config.DatabaseConfig;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * This object is created through Guice, and is a wrapper for the EntityManagerFactory.
 */
@Slf4j
public class MyEntityManagerFactory {

    private EntityManagerFactory emf;
    private DatabaseConfig databaseConfig;

    @Inject
    MyEntityManagerFactory(@MySQL DatabaseConfig databaseConfig) {
        log.info("Creating MyEntityManagerFactory");

        this.databaseConfig = databaseConfig;

        this.emf = Persistence.createEntityManagerFactory("JPA02");
    }

    public EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    public void close() {
        emf.close();
    }
}
