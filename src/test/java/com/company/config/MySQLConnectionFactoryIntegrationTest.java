package com.company.config;

import com.company.MainModule;
import com.company.common.base.binding.MySQL;
import com.company.common.base.config.ConfigInitializer;
import com.company.common.base.db.ConnectionFactory;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.junit.Assert.assertNotNull;

/**
 * To run this test you need to have a running local mysql. You also need to set the correct username and
 * password.
 */
public class MySQLConnectionFactoryIntegrationTest {
  @BeforeClass
  public static void setUpOnce() {
    ConfigInitializer.getInstance().init();
  }

  @Test
  public void getNonNullConnections() throws Exception {
    Injector injector = Guice.createInjector(new MainModule());

    try (ConnectionFactory factory = injector.getInstance(Key.get(ConnectionFactory.class, MySQL.class));
         Connection c1 = factory.getConnection();
         Connection c2 = factory.getUnPooledConnection()) {
      assertNotNull(c1);
      assertNotNull(c2);

      DataSource ds = factory.getOrCreateDataSource();
      assertNotNull(ds);
    }
  }
}
