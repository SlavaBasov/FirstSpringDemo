package org.example.dao;

public interface Dao<T> {
    T findById(int id);
    void save(T t);
}
