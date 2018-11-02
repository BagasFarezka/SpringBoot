package com.bagas.belajar.spring.belajarspringio.controller;

import com.bagas.belajar.spring.belajarspringio.entity.Jurusan;
import com.bagas.belajar.spring.belajarspringio.service.JurusanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class JurusanController {
    private final JurusanService service;

    @Autowired
    public JurusanController(JurusanService service){this.service = service;}

    @GetMapping(value= "/jurusan")
    public List<jurusan> jurusan(){return  service.find();}

    @GetMapping(value = "/jurusan/{kd_jurusan}")
    public Jurusan findById(@PathVariable("Kd_jurusan") Integer id) {
        return service.findById(id);
    }


    @PostMapping(value = "/jurusan")
    public String save(@RequestBody Jurusan jurusan) {
        Jurusan data = service.save(jurusan);
        if (data.getId() == 0) {
            return "Gagal insert data";
        } else {
            return "Insert data berhasil";
        }
    }

    @PutMapping(value = "/jurusan")
    public String update(@RequestBody Jurusan jurusan) {
        Jurusan data = service.update(jurusan);
        if (data.getId() == 0) {
            return "Gagal update data";
        } else {
            return "Update data berhasil";
        }
    }

    @DeleteMapping(value = "/jurusan/{kd_jurusan}")
    public String delete(@PathVariable("id") Integer id) {
        int data = service.delete(new Jurusan(id));
        if (data == 0) {
            return "Gagal delete data";
        } else {
            return "Delete data berhasil";
        }
    }

}






}
