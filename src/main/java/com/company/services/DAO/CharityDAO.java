package com.company.services.DAO;

import com.company.common.base.binding.MySQL;
import com.company.common.base.persist.db.ConnectionFactory;
import com.company.models.CharityEntity;
import com.google.inject.Inject;
import lombok.NonNull;

import javax.persistence.EntityManager;

public class CharityDAO extends BaseTemplateDAOImpl<CharityEntity> {

    private final ConnectionFactory connectionFactory;

    @Inject
    public CharityDAO(@MySQL ConnectionFactory connectionFactory) {
        super(CharityEntity.class);

        this.connectionFactory = connectionFactory;

        /*
        Properties jpaProperties = new Properties();
        //jpaProperties.put("hibernate.connection.url", url);
        //jpaProperties.put("hibernate.connection.username", name);
        //jpaProperties.put("hibernate.connection.password", password);

        String datasourceName = "database." + "x" + ".name";

        // by default, persistence unit name is same as datasource name
        // but can be overridden
        String persistenceUnitName = datasourceName;

        DataSource actualDataSource = new MysqlDataSource();

        //actualDataSource.setDataSourceName("A Data Source name " + datasourceName);
        actualDataSource.setServerName(dbServer);
        actualDataSource.setDatabaseName(databaseName);
        actualDataSource.setUser(name);
        actualDataSource.setPassword(password);
        actualDataSource.setMaxConnections(10);

        jpaProperties.put("hibernate.connection.datasource", actualDataSource);
        emf = Persistence.createEntityManagerFactory(persistenceUnitName, jpaProperties);
        */
    }

    public CharityEntity create(CharityEntity obj, @NonNull EntityManager em) {
        return super.create(obj, em);
    }

    public CharityEntity getById(Long id, @NonNull EntityManager em) {
        return super.getById(id, em);
    }

    public Boolean delete(Long id, @NonNull EntityManager em) {
        return super.deleteById(id, em);
    }
}

