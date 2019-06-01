package com.sydoruk1ua.mdmg.util;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class ConnectorTest {

    @Test
    public void shouldInstallConnection() {
        try {
            assertTrue(Connector.getConnection().isValid(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}