package com.sydoruk1ua.mdmg.model.service.impl;

import com.sydoruk1ua.mdmg.model.dao.UserDao;
import com.sydoruk1ua.mdmg.model.entity.Role;
import com.sydoruk1ua.mdmg.model.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    private static final String EMAIL = "user1@gmail.com";
    private static final String PASSWORD = "user1pass";
    private static final String ENCODED_PASSWORD = "f649db64bf5927c632ad11b417c51e72";
    private Optional<User> user;

    @Mock
    private UserDao userDao;
    @InjectMocks
    private UserServiceImpl userService;

    @Before
    public void setUp() throws Exception {
        user = Optional.of(User.builder()
                .withId(1)
                .withEmail(EMAIL)
                .withPassword(ENCODED_PASSWORD)
                .withFirstName("User1")
                .withLastName("UserLast1")
                .withRole(new Role(2, "user"))
                .build());
    }

    @Test
    public void shouldFindUserByEmailAndPassword() {
        when(userDao.findByEmail(EMAIL)).thenReturn(user);
        Optional<User> userActual = userService.findByEmailAndPassword(EMAIL, PASSWORD);

        assertEquals(user.get(), userActual.get());
        verify(userDao).findByEmail(EMAIL);
    }

    @Test
    public void shouldNotFindUserByEmailAndPassword() {
        when(userDao.findByEmail(EMAIL)).thenReturn(user);
        Optional<User> userActual = userService.findByEmailAndPassword(EMAIL, "wrong_password");

        assertFalse(userActual.isPresent());
        verify(userDao).findByEmail(EMAIL);
    }
}