package com.sydoruk1ua.mdmg.model.service;

import com.sydoruk1ua.mdmg.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void create(User user);

    Optional<User> findByEmail(String email);

    List<User> findAll();

    void update(User user);

    void deleteById(Integer id);
}
