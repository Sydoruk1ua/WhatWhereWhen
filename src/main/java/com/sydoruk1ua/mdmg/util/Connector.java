package com.sydoruk1ua.mdmg.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class Connector {
    private final static Logger LOGGER = Logger.getLogger(Connector.class);
    private static final BasicDataSource DATA_SOURCE = new BasicDataSource();
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("db");

    static {
        LOGGER.log(Level.DEBUG, "entered"); //TODO: delete this
        DATA_SOURCE.setDriverClassName(RESOURCE_BUNDLE.getString("db.driver"));
        DATA_SOURCE.setUrl(RESOURCE_BUNDLE.getString("db.url"));
        DATA_SOURCE.setUsername(RESOURCE_BUNDLE.getString("db.username"));
        DATA_SOURCE.setPassword(RESOURCE_BUNDLE.getString("db.password"));
        DATA_SOURCE.setMinIdle(Integer.parseInt(RESOURCE_BUNDLE.getString("db.min.idle")));
        DATA_SOURCE.setMaxIdle(Integer.parseInt(RESOURCE_BUNDLE.getString("db.max.idle")));
        DATA_SOURCE.setMaxOpenPreparedStatements(Integer.parseInt(RESOURCE_BUNDLE.getString(
                "db.max.open.prepare.statement")));
    }

    private Connector() {
    }

    public static Connection getConnection() {
        try {
            LOGGER.log(Level.DEBUG, "entered"); //TODO: delete this
            return DATA_SOURCE.getConnection();
        } catch (SQLException e) {
            //logger   //TODO: add logger and write own Exception
            LOGGER.log(Level.ERROR, e);
            throw new RuntimeException(e);
        }
    }
}
