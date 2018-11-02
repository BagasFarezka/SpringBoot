package com.bagas.belajar.spring.belajarspringio.dao;

import com.bagas.belajar.spring.belajarspringio.entity.Fakultas;

import java.util.List;

public interface FakultasDao {
    Fakultas save(Fakultas param);

    Fakultas update(Fakultas param);

    String delete(Fakultas param);

    List<Fakultas> find();

    Fakultas findByKd_fakultas(String kd_fakultas);
}
