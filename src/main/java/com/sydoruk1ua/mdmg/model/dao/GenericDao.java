package com.sydoruk1ua.mdmg.model.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {
    void create(T entity);

    Optional<T> findById(Integer id);

    List<T> findAll();  //TODO: realisation should return an empty list, if there are no data

    void update(T entity);

    void deleteById(Integer id);
}
