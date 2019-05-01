package com.company.services;

import com.company.common.base.binding.MySQL;
import com.company.common.base.config.DatabaseConfig;
import com.google.inject.Inject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyEntityManagerFactory {

    private EntityManagerFactory emf;
    private DatabaseConfig databaseConfig;

    @Inject
    MyEntityManagerFactory(@MySQL DatabaseConfig databaseConfig) {
        System.out.println("creating big emf");

        this.databaseConfig = databaseConfig;

        // create the emf
        this.emf = Persistence.createEntityManagerFactory("JPA02");
    }

    public EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    public void close() {
        emf.close();
    }
}
