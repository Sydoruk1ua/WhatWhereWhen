package com.sydoruk1ua.mdmg.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public final class Connector {
    private static final Logger LOGGER = Logger.getLogger(Connector.class);
    private static BasicDataSource dataSource = new BasicDataSource();

    private Connector() {
    }

    public static Connection getConnection() throws SQLException {
        configConnection();
        LOGGER.debug("entered");
        return dataSource.getConnection();
    }

    private static void configConnection() {
        LOGGER.debug("entered");
        dataSource.setDriverClassName(ConfigurationManager.getProperty("db.driver"));
        dataSource.setUrl(ConfigurationManager.getProperty("db.url"));
        dataSource.setUsername(ConfigurationManager.getProperty("db.username"));
        dataSource.setPassword(ConfigurationManager.getProperty("db.password"));
        dataSource.setMinIdle(Integer.parseInt(ConfigurationManager.getProperty("db.min.idle")));
        dataSource.setMaxIdle(Integer.parseInt(ConfigurationManager.getProperty("db.max.idle")));
        dataSource.setMaxOpenPreparedStatements(Integer.parseInt(ConfigurationManager.getProperty(
                "db.max.open.prepare.statement")));
        LOGGER.debug("exit");
    }
}
