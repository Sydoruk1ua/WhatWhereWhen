package com.sydoruk1ua.mdmg.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ValidatorTest {
    //TODO: should rewrite it completely
    @Mock
    private HttpServletRequest request;

    @Test
    public void shouldValidateEmail() {
        String emailExpected = "user1@gmail.com";
        when(request.getParameter("email")).thenReturn(emailExpected);
        assertEquals(emailExpected, Validator.validateEmail(request));
        assertTrue(Validator.isValid());
    }

    @Test
    public void shouldNotValidateEmail() {
        String emailExpected = null;
        when(request.getParameter("email")).thenReturn(null);
        assertEquals(emailExpected, Validator.validateEmail(request));
        assertFalse(Validator.isValid());
    }
}