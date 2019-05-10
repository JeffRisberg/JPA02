package com.company;

import com.company.common.base.binding.MySQL;
import com.company.common.base.config.AppConfig;
import com.company.common.base.config.DatabaseConfig;
import com.company.common.base.services.config.ArchaiusAppConfig;
import com.company.common.base.services.config.MySQLDatabaseConfig;
import com.company.services.*;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

/**
 * @author Jeff Risberg
 * @since 11/30/17
 */
public class MainModule extends AbstractModule {

    protected void configure() {

        //app configs
        //bind(AppConfig.class).to(EnvironmentBasedAppConfig.class).in(Scopes.SINGLETON);
        bind(AppConfig.class).to(ArchaiusAppConfig.class).in(Scopes.SINGLETON);

        // database configs
        bind(DatabaseConfig.class).annotatedWith(MySQL.class).to(MySQLDatabaseConfig.class).in(Scopes.SINGLETON);

        // entityManagerFactory
        bind(MyEntityManagerFactory.class).in(Scopes.SINGLETON);

        // services
        bind(HelloService.class).in(Scopes.SINGLETON);
        bind(CharityService.class).in(Scopes.SINGLETON);
        bind(DonationService.class).in(Scopes.SINGLETON);
        bind(DonorService.class).in(Scopes.SINGLETON);
        bind(OrderService.class).in(Scopes.SINGLETON);
    }
}