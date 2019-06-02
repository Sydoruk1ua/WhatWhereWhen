package com.sydoruk1ua.mdmg.controller.command;

import com.sydoruk1ua.mdmg.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if (session != null) {
            session.removeAttribute("user");
            session.removeAttribute("userRole");
            session.invalidate();
        }
        return ConfigurationManager.getProperty("main.page.path");
    }
}
