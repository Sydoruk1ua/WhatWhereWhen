package com.sydoruk1ua.mdmg;

import com.sydoruk1ua.mdmg.util.MessageManager;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class JustForSomeTests {
    private static final String PASSWORD_REGEX = "^(?=.*?[A-ZА-Я])(?=.*?[a-zа-я])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,45}$";
    private static final String PASSWORD_REGEX1 = "^(?=.*\\d).{6,45}$";

    @Test
    public void testRegex() {
        String email = "alex_test@ukr.net_f649db64bf5927c632ad11b417c51e72";
        String password = "f649db64bf5927c632ad11b417c51e72";
        System.out.println(DigestUtils.md2Hex("jon.smithpasS1!"));
        System.out.println(DigestUtils.md2Hex("judge1pasS1!"));
        String property = MessageManager.getProperty("login.error.message");
        assertEquals(password, DigestUtils.md2Hex("user1pass"));
        assertFalse("1023568".matches(PASSWORD_REGEX));
        assertTrue("nataliya.trachpasS1!".matches(PASSWORD_REGEX));
        assertTrue("nataliyatra chpasS1!".matches(PASSWORD_REGEX));
        assertFalse("nataliyatra chpas".matches(PASSWORD_REGEX));
        assertTrue("natalyatra chpaS1.&".matches(PASSWORD_REGEX));
        assertTrue("natalyatraК chpaS1.&".matches(PASSWORD_REGEX));
        assertTrue("natalyatraпё chpaS1.&".matches(PASSWORD_REGEX));
    }
}