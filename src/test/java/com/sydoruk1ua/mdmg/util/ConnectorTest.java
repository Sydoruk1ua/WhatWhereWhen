package com.sydoruk1ua.mdmg.util;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ConnectorTest {

    @Test
    public void shouldInstallConnection() {
        assertNotNull(Connector.getConnection());
    }
}