package com.sydoruk1ua.mdmg.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public final class Connector {
    private static final Logger LOGGER = Logger.getLogger(Connector.class);
    private static final BasicDataSource DATA_SOURCE = new BasicDataSource();

    private Connector() {
    }

    public static Connection getConnection() {
        try {
            configConnection();
            LOGGER.debug("entered");
            return DATA_SOURCE.getConnection();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new RuntimeException(e); //TODO: write own Exception and find out how to handle it
        }
    }

    private static void configConnection() {
        LOGGER.debug("entered");
        DATA_SOURCE.setDriverClassName(ConfigurationManager.getProperty("db.driver"));
        DATA_SOURCE.setUrl(ConfigurationManager.getProperty("db.url"));
        DATA_SOURCE.setUsername(ConfigurationManager.getProperty("db.username"));
        DATA_SOURCE.setPassword(ConfigurationManager.getProperty("db.password"));
        DATA_SOURCE.setMinIdle(Integer.parseInt(ConfigurationManager.getProperty("db.min.idle")));
        DATA_SOURCE.setMaxIdle(Integer.parseInt(ConfigurationManager.getProperty("db.max.idle")));
        DATA_SOURCE.setMaxOpenPreparedStatements(Integer.parseInt(ConfigurationManager.getProperty(
                "db.max.open.prepare.statement")));
    }
}
