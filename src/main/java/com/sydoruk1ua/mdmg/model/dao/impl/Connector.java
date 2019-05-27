package com.sydoruk1ua.mdmg.model.dao.impl;

import com.mysql.cj.jdbc.Driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {
    private static final String URL;
    private static final String USER_NAME;
    private static final String PASSWORD;

    static {
        Properties props = new Properties();
        try (FileInputStream in = new FileInputStream(new File("./src/main/resources/db.properties"))) {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace(); //TODO: handle it and add logger
        }
        URL = props.getProperty("db.url");
        USER_NAME = props.getProperty("db.username");
        PASSWORD = props.getProperty("db.password");
    }

    public Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            //logger   //TODO: add logger and write own Exception
            throw new RuntimeException(e);
        }
    }
}
