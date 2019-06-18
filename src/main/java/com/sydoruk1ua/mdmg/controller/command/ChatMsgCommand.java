package com.sydoruk1ua.mdmg.controller.command;

import com.sydoruk1ua.mdmg.util.ConfigurationManager;
import com.sydoruk1ua.mdmg.util.DbConnectionPoolUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatMsgCommand implements Command {
    //TODO: maybe I should delete this, if I don't want to split game and chat realization
    private static final String INSERT_INTO_MESSAGES = "INSERT INTO messages(login, msg, data, time) " +
            "VALUES(?, ?, ?, ?)";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PreparedStatement statement = DbConnectionPoolUtil.getConnection().prepareStatement(INSERT_INTO_MESSAGES)
        ) {
            resp.setContentType("text/html");

            // insert message to table messages

            String login = req.getParameter("login");
            String msg = req.getParameter("msg");
            Date date = new Date();
            SimpleDateFormat day = new SimpleDateFormat("dd/MMM/yy");
            SimpleDateFormat hour = new SimpleDateFormat("hh:mm:ss a");

            statement.setString(1, login);
            statement.setString(2, msg);
            statement.setString(3, day.format(date));
            statement.setString(4, hour.format(date));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ConfigurationManager.getProperty("game.page.path");
    }
}
