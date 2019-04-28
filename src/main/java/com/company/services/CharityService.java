package com.company.services;

import com.company.common.FilterDescription;
import com.company.common.base.binding.MySQL;
import com.company.common.base.persist.db.ConnectionFactory;
import com.company.models.CharityEntity;
import com.company.services.DAO.CharityDAO;
import com.google.inject.Inject;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.persistence.Persistence;
import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

public class CharityService extends AbstractService<CharityEntity> {
    private static CharityDAO dao = new CharityDAO();

    private final ConnectionFactory mySQLConnectionFactory;

    @Inject
    public CharityService(final @MySQL ConnectionFactory mySQLConnectionFactory) {
        this.mySQLConnectionFactory = mySQLConnectionFactory;

        try {
            Connection connection = mySQLConnectionFactory.getConnection();
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Properties jpaProperties = new Properties();
        //jpaProperties.put("hibernate.connection.url", url);
        //jpaProperties.put("hibernate.connection.username", name);
        //jpaProperties.put("hibernate.connection.password", password);

        String datasourceName = "database." + "x" + ".name";

        // by default, persistence unit name is same as datasource name
        // but can be overridden
        String persistenceUnitName = datasourceName;

        DataSource actualDataSource = new MysqlDataSource();
        /*
        //actualDataSource.setDataSourceName("A Data Source name " + datasourceName);
        actualDataSource.setServerName(dbServer);
        actualDataSource.setDatabaseName(databaseName);
        actualDataSource.setUser(name);
        actualDataSource.setPassword(password);
        actualDataSource.setMaxConnections(10);
        */

        jpaProperties.put("hibernate.connection.datasource", actualDataSource);
        emf = Persistence.createEntityManagerFactory(persistenceUnitName, jpaProperties);


        this.emf = Persistence.createEntityManagerFactory("JPA02");
    }

    public CharityEntity create(CharityEntity charity) {
        final AtomicReference<CharityEntity> created = new AtomicReference<>();
        doWork(em -> created.set(dao.create(charity, em)));
        return created.get();
    }

    public CharityEntity getById(Long id) {
        final AtomicReference<CharityEntity> td = new AtomicReference<>();
        doWork(em -> td.set(dao.getById(id, em)));
        return td.get();
    }

    public List<CharityEntity> getAll(int limit, int offset) {
        final AtomicReference<List<CharityEntity>> td = new AtomicReference<>();
        doWork(em -> td.set(dao.listAll(CharityEntity.class, limit, offset, em)));
        return td.get();
    }

    public List<CharityEntity> getByCriteria(List<FilterDescription> filterDescriptions, int limit, int offset) {
        final AtomicReference<List<CharityEntity>> td = new AtomicReference<>();
        doWork(em -> td.set(dao.getByCriteria(filterDescriptions, limit, offset, em)));
        return td.get();
    }

    public boolean update(CharityEntity updatedEntity) {
        final AtomicReference<Boolean> updated = new AtomicReference<>();
        doWork(em -> updated.set(dao.update(updatedEntity, em)));
        return updated.get();
    }

    public boolean delete(Long id) {
        final AtomicReference<Boolean> deleted = new AtomicReference<>();
        doWork(em -> deleted.set(dao.delete(id, em)));
        return deleted.get();
    }

    public CharityEntity getByName(String name) {
        final AtomicReference<CharityEntity> td = new AtomicReference<>();
        doWork(em -> td.set(dao.getByName(name, em)));
        return td.get();
    }
}

