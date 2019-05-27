package com.sydoruk1ua.mdmg.model.dao.impl;

import com.sydoruk1ua.mdmg.util.Connector;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ConnectorTest {

    @Test
    public void shouldCreateConnection() {
        assertNotNull(Connector.getConnection());
    }
}