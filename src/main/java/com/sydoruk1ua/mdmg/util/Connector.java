package com.sydoruk1ua.mdmg.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public final class Connector {
    private static final Logger LOGGER = Logger.getLogger(Connector.class);
    private static BasicDataSource dataSource;

    private Connector() {
    }

    public static Connection getConnection() throws SQLException {
        configConnection();
        LOGGER.debug("entered");
        return dataSource.getConnection();
    }

    private static void configConnection() {
        LOGGER.debug("entered");
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(ConfigurationManager.getProperty("db.driver"));
        ds.setUrl(ConfigurationManager.getProperty("db.url"));
        ds.setUsername(ConfigurationManager.getProperty("db.username"));
        ds.setPassword(ConfigurationManager.getProperty("db.password"));
        dataSource = ds;
        LOGGER.debug("exit");
    }
}