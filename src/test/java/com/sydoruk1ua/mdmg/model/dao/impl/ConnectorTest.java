package com.sydoruk1ua.mdmg.model.dao.impl;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ConnectorTest {

    @Test
    public void shouldCreateConnection() {
        Connector connector = new Connector();
        assertNotNull(connector.getConnection());
    }
}