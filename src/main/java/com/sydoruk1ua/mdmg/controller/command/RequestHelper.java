package com.sydoruk1ua.mdmg.controller.command;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class RequestHelper {
    private static RequestHelper instance = null;

    Map<String, Command> commands = new HashMap<>();

    private RequestHelper() {
//заполнение таблицы командами
        commands.put("login", new LoginCommand() {
        });
    }

    //создание единственного объекта по шаблону Singleton
    public static RequestHelper getInstance() {
        if (instance == null) {
            instance = new RequestHelper();
        }

        return instance;
    }

    public Command getCommand(HttpServletRequest request) {
//извлечение команды из запроса
        String action = request.getParameter("command");

//получение объекта, соответствующего команде

        Command command = commands.get(action);
        if (command == null) {
//если команды не существует в текущем объекте
            command = new NoCommand();
        }

        return command;
    }
}
