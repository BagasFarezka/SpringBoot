package com.bagas.belajar.spring.belajarspringio.service;

import java.util.List;

public interface BaseService<T> {
    T save (T param);
    T update (T param);
    String delete (T param);

    List<T> find();

    T findByKd_Fakultas(String kd_fakultas);

}
