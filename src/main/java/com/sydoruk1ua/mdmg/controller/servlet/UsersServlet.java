package com.sydoruk1ua.mdmg.controller.servlet;

import com.sydoruk1ua.mdmg.model.dao.impl.UserDaoImpl;
import com.sydoruk1ua.mdmg.model.service.UserService;
import com.sydoruk1ua.mdmg.model.service.impl.UserServiceImpl;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {
    private final static Logger LOGGER = Logger.getLogger(UsersServlet.class);

    private final UserService userService = new UserServiceImpl(new UserDaoImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.log(Level.DEBUG, "entered");     //TODO delete this
        System.out.println("test");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/users.jsp");
        req.setAttribute("usersList", userService.findAll());
        dispatcher.forward(req, resp);
    }
}
