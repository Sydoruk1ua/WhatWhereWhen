package com.sydoruk1ua.mdmg.controller.command;

import com.sydoruk1ua.mdmg.model.entity.Message;
import com.sydoruk1ua.mdmg.model.service.MessageService;
import com.sydoruk1ua.mdmg.util.ConfigurationManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GameCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(GameCommand.class);

    private static final String GET_MESSAGES = "SELECT * from messages ORDER BY 1";
    private static final String GAME_PAGE_PATH = "game.page.path";
    private final MessageService messageService;

    public GameCommand(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String userEmail = req.getParameter("nickname");
        String msg = req.getParameter("msg");

        messageService.create(new Message(userEmail, msg));

        req.setAttribute("messageList", messageService.findAll());
   /*     LOGGER.debug("start");
        if (!userMessages.containsKey(request.getParameter("from"))) {
            userMessages.put(request.getParameter("from"), new ArrayList<String>());
            LOGGER.debug("if 1");
        }
        for (Map.Entry<String, ArrayList<String>> msg : userMessages.entrySet()) {
            msg.getValue().add(request.getParameter("from") + ": " + request.getParameter("message"));
            LOGGER.debug("for 1");
        }
        String responseText = "";
        for (String msg : userMessages.get(request.getParameter("from"))) {
            responseText += msg + "<br>";
            LOGGER.debug("for 2" + responseText);
        }
      //  userMessages.get(request.getParameter("from")).clear();
        response.getWriter().write(responseText);
        LOGGER.debug(responseText + "end");*/
        /*PrintWriter out = resp.getWriter();
        List<String> messageList = new ArrayList<>();
        try (PreparedStatement statement = DbConnectionPoolUtil.getConnection().prepareStatement(GET_MESSAGES);
             ResultSet rs = statement.executeQuery()) {

            resp.setContentType("text/html");
            while (rs.next()) {

                String login = rs.getString(2);
                String msg = rs.getString(3);
                String date = rs.getString(4);
                String time = rs.getString(5);

                messageList.add("<p><font size=1>" + date + " " + time + "</font><font size=2><b> " + login + "</b><g> " + msg);
            }

            req.getServletContext().setAttribute("listM", messageList);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return ConfigurationManager.getProperty(GAME_PAGE_PATH);
    }
}
