package com.sydoruk1ua.mdmg.model.service.impl;

import com.sydoruk1ua.mdmg.model.dao.UserDao;
import com.sydoruk1ua.mdmg.model.entity.User;
import com.sydoruk1ua.mdmg.model.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void create(User user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        //return Optional.empty();
        throw new UnsupportedOperationException();
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void update(User user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException();
    }
}
