package com.company.common.base.sql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

/**
 * Hibernate session management utils
 * Singleton that initializes the session factory and facilitates using of a
 * session per tenant
 */
public class DBSessionManager {
  private static final Logger logger = LoggerFactory.getLogger(DBSessionManager.class);
  private final SessionFactory sessionFactory;
  private static DBSessionManager instance = null;
  public static final String DEFAULT_TENANT_STORE_DB_NAME = "tenant_store";

  public static final synchronized DBSessionManager getInstance() {
    if (instance == null) {
      instance = new DBSessionManager();
      Runtime.getRuntime().addShutdownHook(new Thread(() -> instance.close()));
    }

    return instance;
  }

  private DBSessionManager() {
    Configuration configuration = new Configuration().configure(
            DBSessionManager.class.getResource("/config/hibernate.cfg.xml"));
    sessionFactory = configuration.buildSessionFactory();
  }


  /**
   * Think about keeping session across different calls
   * Keeping sessions helps caching of objects and reduce the calls to the database for reads
   *
   *
   * @param namespace
   * @param consumer
   */
  public void useSession(String namespace, Consumer<Session> consumer) {
    try {
      useSessionUnsafe(namespace, consumer);
    } catch (Throwable e) {
      logger.error("Failed to execute transaction", e);
    }
  }

  public void useSessionUnsafe(String namespace, Consumer<Session> consumer) {
    try (Session session = sessionFactory.withOptions()
      .tenantIdentifier(namespace).openSession()) {
      Transaction transaction = session.beginTransaction();

      try {
        // call consumer
        consumer.accept(session);

        transaction.commit();
      } catch (Throwable e) {
        transaction.rollback();
        logger.error("Failed to execute transaction", e);
        throw e;
      }
    }
  }

  private void close() {
    this.sessionFactory.close();
  }
}
