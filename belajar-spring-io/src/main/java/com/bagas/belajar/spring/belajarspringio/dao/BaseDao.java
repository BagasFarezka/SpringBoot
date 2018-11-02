package com.bagas.belajar.spring.belajarspringio.dao;

import java.util.List;
public interface BaseDao<T> {
    T save(T param);
    T update(T param);
    String delete(T param);
    List<T> find();
    T findById(String kd_fakultas);
}
