package com.sydoruk1ua.mdmg.util;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public final class Validator {
    private static final Logger LOGGER = Logger.getLogger(Validator.class);

    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String PASSWORD_REPEAT = "password_repeat";
    private static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"" +
            "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])" +
            "*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4]" +
            "[0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-" +
            "\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])";
    /**
     * Password must contain:
     * At least one upper case letter, (?=.*?[A-ZА-Я])
     * At least one lower case letter, (?=.*?[a-zа-я])
     * At least one digit, (?=.*?[0-9])
     * At least one special character, (?=.*?[#?!@$%^&*-])
     * Length must be between 6 and 45 characters .{6,45}
     */
    private static final String PASSWORD_REGEX = "^(?=.*?[A-ZА-Я])(?=.*?[a-zа-я])(?=.*?[0-9])" +
            "(?=.*?[#?!@$%^&*-]).{6,45}$";
    private static final String FIRST_NAME_REGEX = "[а-яА-ЯёЁa-zA-Z`-]{1,45}+";
    private static final String LAST_NAME_REGEX = "[а-яА-ЯёЁa-zA-Z`-]{1,45}+";
    private static final String EMAIL_ERROR = "email_error";
    private static final String PASSWORD_ERROR = "password_error";
    private static final String FIRST_NAME_ERROR = "first_name_error";
    private static final String LAST_NAME_ERROR = "last_name_error";
    private static final String PASSWORD_REPEAT_ERROR = "password_repeat_error";

    private static boolean isValid = true;

    private Validator() {
    }

    //TODO: don't forget to handle all these errors in jsp
    public static String validateEmail(HttpServletRequest request) {
        String value = request.getParameter(EMAIL);
        if (!value.matches(EMAIL_REGEX)) {
            LOGGER.debug(MessageManager.getProperty("error.incorrect.email"));
            isValid = validationFailed(request, EMAIL_ERROR,
                    MessageManager.getProperty("error.incorrect.email"));
        }
        return value;
    }


    public static String validatePassword(HttpServletRequest request) {
        String value = request.getParameter(PASSWORD);
        if (!value.matches(PASSWORD_REGEX)) {
            LOGGER.debug(MessageManager.getProperty("error.incorrect.password"));
            isValid = validationFailed(request, PASSWORD_ERROR,
                    MessageManager.getProperty("error.incorrect.password"));
        }
        return value;
    }

    public static void validateRepeatPassword(HttpServletRequest request, String password) {
        String value = request.getParameter(PASSWORD_REPEAT);
        if (!value.equals(password)) {
            LOGGER.debug(MessageManager.getProperty("error.passwords.do.not.match"));
            isValid = validationFailed(request, PASSWORD_REPEAT_ERROR,
                    MessageManager.getProperty("error.passwords.do.not.match"));
        }
    }

    public static String validateFirsName(HttpServletRequest request) {
        String value = request.getParameter(FIRST_NAME);
        if (!value.matches(FIRST_NAME_REGEX)) {
            LOGGER.debug(MessageManager.getProperty("error.incorrect.first.name"));
            isValid = validationFailed(request, FIRST_NAME_ERROR,
                    MessageManager.getProperty("error.incorrect.first.name"));
        }
        return value;
    }

    public static String validateLastName(HttpServletRequest request) {
        String value = request.getParameter(LAST_NAME);
        if (!value.matches(LAST_NAME_REGEX)) {
            LOGGER.debug(MessageManager.getProperty("error.incorrect.last.name"));
            isValid = validationFailed(request, LAST_NAME_ERROR,
                    MessageManager.getProperty("error.incorrect.last.name"));
        }
        return value;
    }

    public static boolean isValid() {
        return isValid;
    }

    private static boolean validationFailed(HttpServletRequest request, String attributeName, String message) {
        request.getSession().setAttribute(attributeName, message);
        return false;
    }
}
