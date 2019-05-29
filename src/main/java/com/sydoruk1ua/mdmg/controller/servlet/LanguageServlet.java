package com.sydoruk1ua.mdmg.controller.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/language")
public class LanguageServlet extends HttpServlet {

    public static final String LANG = "lang";
    public static final String EN = "en_EN";
    public static final String RU = "ru_RU";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lang = req.getParameter(LANG);
        if (lang.equals(EN)) {
            req.getSession().setAttribute(LANG, EN);
        } else {
            req.getSession().setAttribute(LANG, RU);
        }
        StringBuffer requestURL = req.getRequestURL();

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/home.jsp");
        dispatcher.forward(req, resp);
    }
}
