package org.example.repository;

import java.util.List;

public interface Repository<T> {
    void add(T entity);
    void remove(T entity);
    void update(T entity);
    List findById();

    //List query(Specification specification);
}
