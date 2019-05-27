package com.sydoruk1ua.mdmg;

import com.sydoruk1ua.mdmg.model.dao.impl.UserDaoImpl;
import org.apache.log4j.Logger;

public class MainServlet {
    private final static Logger LOGGER = Logger.getLogger(MainServlet.class);

    public static void main(String[] args) {
        System.out.println(new UserDaoImpl().findAll().size());
        System.out.println(System.getProperty("user.dir"));
    }
}