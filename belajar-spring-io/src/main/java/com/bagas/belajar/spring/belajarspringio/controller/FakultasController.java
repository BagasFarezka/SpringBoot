package com.bagas.belajar.spring.belajarspringio.controller;

import com.bagas.belajar.spring.belajarspringio.entity.Fakultas;
import com.bagas.belajar.spring.belajarspringio.service.FakultasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FakultasController {
    private final FakultasService service;

    @Autowired
    public FakultasController(FakultasService service) {
        this.service = service;
    }

    @GetMapping(value = "/fakultas")
    public List<Fakultas> fakultas() {
        return service.find();
    }

    @GetMapping(value = "/fakultas/{kd_fakultas}")
    public Fakultas findById(@PathVariable("kd_fakultas") String kd_fakultas) {
        return service.findByKd_Fakultas(kd_fakultas);
    }

    @PostMapping(value = "/fakultas")
    public String save(@RequestBody Fakultas fakultas) {
        Fakultas data = service.save(fakultas);
        if (data.getKd_fakultas() == null) {
            return "Gagal insert data";
        } else {
            return "Insert data berhasil";
        }
    }

    @PutMapping(value = "/fakultas")
    public String update(@RequestBody Fakultas fakultas) {
        Fakultas data = service.update(fakultas);
        if (data.getKd_fakultas() == null) {
            return "Gagal update data";
        } else {
            return "Update data berhasil";
        }
    }

    @DeleteMapping(value = "/fakultas/{kd_fakultas}")
    public String delete(@PathVariable("kd_fakultas") String kd_fakultas) {
        String data = service.delete(new Fakultas(kd_fakultas));
        if (data == null) {
            return "Gagal delete data";
        } else {
            return "Delete data berhasil";
        }
    }
}
