package com.sydoruk1ua.mdmg.util;

import com.sydoruk1ua.mdmg.util.constant.Attributes;
import com.sydoruk1ua.mdmg.util.constant.ErrorMessages;
import com.sydoruk1ua.mdmg.util.constant.Parameters;

import javax.servlet.http.HttpServletRequest;

public class Validator {
    public static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"" +
            "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])" +
            "*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4]" +
            "[0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:" +
            "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"; //TODO: add check for length 45 characters.
    /**
     * Password must contain at least one letter, at least one number. It must be between 6 and 45 characters
     */
    public static final String PASSWORD_REGEX = "^(?=.*[0-9]+.*)(?=.*[a-zA-Z]+.*)[0-9a-zA-Z]{6,45}$";
    public static final String FIRST_NAME_REGEX = "[а-яА-ЯёЁa-zA-Z`-]{1,45}+";
    public static final String LAST_NAME_REGEX = "[а-яА-ЯёЁa-zA-Z`-]{1,45}+";

    private boolean isValid = true;

    public String inputEmail(HttpServletRequest request) {
        String value = request.getParameter(Parameters.EMAIL);
        if (!value.matches(EMAIL_REGEX)) {
            isValid = validationFailed(request, Attributes.EMAIL_ERROR, ErrorMessages.INCORRECT_EMAIL);
        }
        return value;
    }

    public String inputPassword(HttpServletRequest request) {
        String value = request.getParameter(Parameters.PASSWORD);
        if (!value.matches(PASSWORD_REGEX)) {
            isValid = validationFailed(request, Attributes.PASSWORD_ERROR, ErrorMessages.INCORRECT_PASSWORD);
        }
        return value;
    }

    public void inputRepeatPassword(HttpServletRequest request, String password) {
        String value = request.getParameter(Parameters.PASSWORD_REPEAT);
        if (!value.equals(password)) {
            isValid = validationFailed(request, Attributes.PASSWORD_REPEAT_ERROR, ErrorMessages.PASSWORDS_DONT_MATCH);
        }
    }

    public String inputFirsName(HttpServletRequest request) {
        String value = request.getParameter(Parameters.FIRST_NAME);
        if (!value.matches(FIRST_NAME_REGEX)) {
            isValid = validationFailed(request, Attributes.FIRST_NAME_ERROR, ErrorMessages.INCORRECT_FIRST_NAME);
        }
        return value;
    }

    public String inputLastName(HttpServletRequest request) {
        String value = request.getParameter(Parameters.LAST_NAME);
        if (!value.matches(LAST_NAME_REGEX)) {
            isValid = validationFailed(request, Attributes.LAST_NAME_ERROR, ErrorMessages.INCORRECT_LAST_NAME);
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
