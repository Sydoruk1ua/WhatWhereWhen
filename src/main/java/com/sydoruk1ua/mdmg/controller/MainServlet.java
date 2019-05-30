package com.sydoruk1ua.mdmg.controller;

import com.sydoruk1ua.mdmg.controller.command.Command;
import com.sydoruk1ua.mdmg.controller.command.RequestHelper;
import com.sydoruk1ua.mdmg.util.ConfigurationManager;
import com.sydoruk1ua.mdmg.util.MessageManager;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class MainServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(MainServlet.class);
    private static final RequestHelper REQUEST_HELPER = RequestHelper.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String page = null;

        try {
//определение команды, пришедшей из JSP
            Command command = REQUEST_HELPER.getCommand(request);
/*вызов реализованного метода execute() интерфейса Command и передача
параметров классу-обработчику конкретной команды*/
            page = command.execute(request, response);
// метод возвращает страницу ответа
        } catch (ServletException e) {
            LOGGER.error(e.getMessage(), e);
//генерация сообщения об ошибке
            request.setAttribute("errorMessage", MessageManager.getProperty("servlet.exception.error.message"));
//вызов JSP-страницы c cообщением об ошибке
            page = ConfigurationManager.getProperty("error.page.path");
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);

            request.setAttribute("errorMessage", MessageManager.getProperty("io.exception.error.message"));

            page = ConfigurationManager.getProperty("error.page.path");
        }
//вызов страницы ответа на запрос
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}