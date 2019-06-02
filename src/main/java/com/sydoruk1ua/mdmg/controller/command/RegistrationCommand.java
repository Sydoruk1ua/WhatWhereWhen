package com.sydoruk1ua.mdmg.controller.command;

import com.sydoruk1ua.mdmg.model.entity.User;
import com.sydoruk1ua.mdmg.model.service.UserService;
import com.sydoruk1ua.mdmg.util.ConfigurationManager;
import com.sydoruk1ua.mdmg.util.MessageManager;
import com.sydoruk1ua.mdmg.util.Validator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(RegistrationCommand.class);
    private final UserService userService;

    public RegistrationCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String email = Validator.validateEmail(request);
        String password = Validator.validatePassword(request);
        Validator.validateRepeatPassword(request, password);
        String firstName = Validator.validateFirsName(request);
        String lastName = Validator.validateLastName(request);

        if (!Validator.isValid()) {
            LOGGER.debug("Registration failed because of invalid data");
            return ConfigurationManager.getProperty("registration.page.path");
        }

        if (userService.findByEmail(email).isPresent()) {
            LOGGER.debug(MessageManager.getProperty("error.user.email.already.exist"));
            request.getSession().setAttribute("user_email_error",
                    MessageManager.getProperty("error.user.email.already.exist"));
            return ConfigurationManager.getProperty("registration.page.path");
        }

        User user = User.builder()
                .withEmail(email)
                .withFirstName(firstName)
                .withLastName(lastName)
                .withPassword(password)
                .build();

        userService.create(user);
        LOGGER.debug("User " + email + " successfully registered");
        request.getSession().setAttribute("user", email);
        request.getSession().setAttribute("userRole", "user");
        return ConfigurationManager.getProperty("main.page.path");
    }
}
