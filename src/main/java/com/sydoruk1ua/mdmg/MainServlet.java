package com.sydoruk1ua.mdmg;

import com.sydoruk1ua.mdmg.model.entity.User;
import org.apache.log4j.Logger;

public class MainServlet {
    private final static Logger LOGGER = Logger.getLogger(MainServlet.class);

    public static void main(String[] args) {
        User user = new User.Builder("email", "password").build();
    }
}