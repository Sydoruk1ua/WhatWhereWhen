package com.sydoruk1ua.mdmg.controller.command;

import com.sydoruk1ua.mdmg.model.dao.impl.UserDaoImpl;
import com.sydoruk1ua.mdmg.model.service.UserService;
import com.sydoruk1ua.mdmg.model.service.impl.UserServiceImpl;
import com.sydoruk1ua.mdmg.util.ConfigurationManager;
import com.sydoruk1ua.mdmg.util.MessageManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(LoginCommand.class);
    private static final String PARAM_NAME_LOGIN = "email";
    private static final String PARAM_NAME_PASSWORD = "password";
    private final UserService userService = new UserServiceImpl(new UserDaoImpl());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

//извлечение из запроса логина и пароля
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
//проверка логина и пароля
        if (userService.findByEmailAndPassword(login, pass).isPresent()) {
            request.setAttribute("user", login);
//определение пути к main.jsp
            page = ConfigurationManager.getProperty("main.page.path");
        } else {
            LOGGER.debug("entered else block");
            request.setAttribute("errorMessage", MessageManager.getProperty("login.error.message"));
            page = ConfigurationManager.getProperty("error.page.path");
            LOGGER.debug("exit else block");
        }

        return page;
    }
}
