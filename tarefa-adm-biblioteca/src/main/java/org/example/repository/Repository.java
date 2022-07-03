package org.example.repository;

import java.util.List;

import org.example.model.BaseModel;

public interface Repository<T extends BaseModel<ID>, ID> {
    void add(T entity);
    void remove(T entity);
    void update(T entity);
    List<T> getAll();
    T findById(ID id);
    // List<T> query(Criteria specification);
}
