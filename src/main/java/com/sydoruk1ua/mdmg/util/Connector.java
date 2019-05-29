package com.sydoruk1ua.mdmg.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class Connector {
    private final static Logger LOGGER = Logger.getLogger(Connector.class);
    private static final BasicDataSource DATA_SOURCE = new BasicDataSource();
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("db");

    private Connector() {
    }

    public static Connection getConnection() {
        try {
            configConnection();
            LOGGER.debug("entered");
            return DATA_SOURCE.getConnection();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new RuntimeException(e); //TODO: write own Exception
        }
    }

    private static void configConnection() {
        LOGGER.debug("entered");
        DATA_SOURCE.setDriverClassName(RESOURCE_BUNDLE.getString("db.driver"));
        DATA_SOURCE.setUrl(RESOURCE_BUNDLE.getString("db.url"));
        DATA_SOURCE.setUsername(RESOURCE_BUNDLE.getString("db.username"));
        DATA_SOURCE.setPassword(RESOURCE_BUNDLE.getString("db.password"));
        DATA_SOURCE.setMinIdle(Integer.parseInt(RESOURCE_BUNDLE.getString("db.min.idle")));
        DATA_SOURCE.setMaxIdle(Integer.parseInt(RESOURCE_BUNDLE.getString("db.max.idle")));
        DATA_SOURCE.setMaxOpenPreparedStatements(Integer.parseInt(RESOURCE_BUNDLE.getString(
                "db.max.open.prepare.statement")));
    }
}
