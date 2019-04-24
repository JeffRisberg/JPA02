package com.company;

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
public class MainModule extends ServletModule {

    @Override
    protected void configureServlets() {

        //configs
        bind(DatabaseConfig.class).annotatedWith(MySQL.class).to(EnvironmentBasedMySQLConfiguration.class).in(Scopes.SINGLETON);
        bind(AppConfig.class).to(EnvironmentBasedAppConfig.class).in(Scopes.SINGLETON);

        bind(CharityService.class).in(Scopes.SINGLETON);
        bind(DonationService.class).in(Scopes.SINGLETON);
        bind(DonorService.class).in(Scopes.SINGLETON);
        bind(OrderService.class).in(Scopes.SINGLETON);
    }
}