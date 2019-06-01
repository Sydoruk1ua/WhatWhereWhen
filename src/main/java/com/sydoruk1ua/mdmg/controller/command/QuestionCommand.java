package com.sydoruk1ua.mdmg.controller.command;

import com.sydoruk1ua.mdmg.model.service.QuestionService;
import com.sydoruk1ua.mdmg.util.ConfigurationManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(QuestionCommand.class);
    private QuestionService questionService;

    public QuestionCommand(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("questionsList", questionService.findAll());
        LOGGER.debug("Count of all questions: " + questionService.findAll().size());
        return ConfigurationManager.getProperty("questions.page.path");
    }
}
