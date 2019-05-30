package com.sydoruk1ua.mdmg.util;

import com.sydoruk1ua.mdmg.util.constant.Attributes;
import com.sydoruk1ua.mdmg.util.constant.Parameters;

import javax.servlet.http.HttpServletRequest;

public class Validator {
    private static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"" +
            "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])" +
            "*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4]" +
            "[0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:" +
            "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"; //TODO: add check for length 45 characters.
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

    private boolean isValid = true;

    public String inputEmail(HttpServletRequest request) {
        String value = request.getParameter(Parameters.EMAIL);
        if (!value.matches(EMAIL_REGEX)) {
            isValid = validationFailed(request, Attributes.EMAIL_ERROR,
                    MessageManager.getProperty("incorrect.email"));
        }
        return value;
    }

    public String inputPassword(HttpServletRequest request) {
        String value = request.getParameter(Parameters.PASSWORD);
        if (!value.matches(PASSWORD_REGEX)) {
            isValid = validationFailed(request, Attributes.PASSWORD_ERROR,
                    MessageManager.getProperty("incorrect.password"));
        }
        return value;
    }

    public void inputRepeatPassword(HttpServletRequest request, String password) {
        String value = request.getParameter(Parameters.PASSWORD_REPEAT);
        if (!value.equals(password)) {
            isValid = validationFailed(request, Attributes.PASSWORD_REPEAT_ERROR,
                    MessageManager.getProperty("passwords.do.not.match"));
        }
    }

    public String inputFirsName(HttpServletRequest request) {
        String value = request.getParameter(Parameters.FIRST_NAME);
        if (!value.matches(FIRST_NAME_REGEX)) {
            isValid = validationFailed(request, Attributes.FIRST_NAME_ERROR,
                    MessageManager.getProperty("incorrect.first.name"));
        }
        return value;
    }

    public String inputLastName(HttpServletRequest request) {
        String value = request.getParameter(Parameters.LAST_NAME);
        if (!value.matches(LAST_NAME_REGEX)) {
            isValid = validationFailed(request, Attributes.LAST_NAME_ERROR,
                    MessageManager.getProperty("incorrect.last.name"));
        }
        return value;
    }


    private boolean validationFailed(HttpServletRequest request, String attributeName, String message) {
        request.getSession().setAttribute(attributeName, message);
        return false;
    }


    public boolean isValid() {
        return isValid;
    }
}
