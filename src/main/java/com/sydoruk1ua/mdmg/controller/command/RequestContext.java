package com.sydoruk1ua.mdmg.controller.command;

import com.sydoruk1ua.mdmg.model.dao.impl.QuestionDaoImpl;
import com.sydoruk1ua.mdmg.model.dao.impl.UserDaoImpl;
import com.sydoruk1ua.mdmg.model.service.QuestionService;
import com.sydoruk1ua.mdmg.model.service.UserService;
import com.sydoruk1ua.mdmg.model.service.impl.QuestionServiceImpl;
import com.sydoruk1ua.mdmg.model.service.impl.UserServiceImpl;
import com.sydoruk1ua.mdmg.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class RequestContext {
    private static RequestContext instance = null;
    private UserService userService = new UserServiceImpl(new UserDaoImpl());
    private QuestionService questionService = new QuestionServiceImpl(new QuestionDaoImpl());


    private Map<String, Command> commands = new HashMap<>();

    private RequestContext() {
        commands.put("login", new LoginCommand(userService));
        commands.put("questions", new QuestionCommand(questionService));

        // Commands for redirect to concrete pages
        commands.put("login.page", (req, res) -> ConfigurationManager.getProperty("login.page.path"));
        commands.put("main.page", (req, res) -> ConfigurationManager.getProperty("main.page.path"));
    }


    public static RequestContext getInstance() {
        if (instance == null) {
            instance = new RequestContext();
        }

        return instance;
    }

    public Command getCommand(HttpServletRequest request) {
        String action = request.getParameter("command");

        Command command = commands.get(action);
        if (command == null) {
            command = new NoCommand();
        }

        return command;
    }
}
