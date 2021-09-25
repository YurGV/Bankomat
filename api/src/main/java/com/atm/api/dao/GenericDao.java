package com.atm.api.dao;

import java.util.List;

public interface GenericDao<T> {

    void save(T entity);
    T getById(Long id);
    List<T> getAll();
    T update(T entity);
    void delete(T entity);

}
