package com.sydoruk1ua.mdmg.util;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidatorTest {

    @Test
    public void shouldValidateEmail() {
        String emailWithLength45 = "user1234567891234567891234567891234@gmail.com";
        assertTrue(Validator.isEmailValid("user1@gmail.com"));
        assertTrue(Validator.isEmailValid(emailWithLength45));
    }

    @Test
    public void shouldNotValidateEmail() {
        String emailWithLength46 = "user12345678912345678912345678912345@gmail.com";
        assertFalse(Validator.isEmailValid(null));
        assertFalse(Validator.isEmailValid(emailWithLength46));
    }
}