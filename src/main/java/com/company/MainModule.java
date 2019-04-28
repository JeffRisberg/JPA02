package com.company;

import com.company.common.base.persist.db.ConnectionFactory;
import com.company.common.base.persist.db.MySQLConnectionFactory;
import com.company.common.base.services.config.ArchaiusAppConfig;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.servlet.ServletModule;
import com.company.common.base.binding.MySQL;
import com.company.common.base.config.AppConfig;
import com.company.common.base.config.DatabaseConfig;
import com.company.common.base.services.config.EnvironmentBasedAppConfig;
import com.company.common.base.services.config.EnvironmentBasedMySQLConfiguration;
import com.company.services.*;

/**
 * @author Jeff Risberg
 * @since 11/30/17
 */
public class MainModule extends AbstractModule {

    protected void configure() {

        //configs
        //bind(AppConfig.class).to(EnvironmentBasedAppConfig.class).in(Scopes.SINGLETON);
        bind(AppConfig.class).to(ArchaiusAppConfig.class).in(Scopes.SINGLETON);

        bind(DatabaseConfig.class).annotatedWith(MySQL.class).to(EnvironmentBasedMySQLConfiguration.class).in(Scopes.SINGLETON);

        bind(ConnectionFactory.class).annotatedWith(MySQL.class).to(MySQLConnectionFactory.class).in(Scopes.SINGLETON);

        bind(CharityService.class).in(Scopes.SINGLETON);
        bind(DonationService.class).in(Scopes.SINGLETON);
        bind(DonorService.class).in(Scopes.SINGLETON);
        bind(OrderService.class).in(Scopes.SINGLETON);
    }
}