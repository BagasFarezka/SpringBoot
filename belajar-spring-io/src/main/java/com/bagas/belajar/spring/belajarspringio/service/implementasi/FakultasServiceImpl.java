package com.bagas.belajar.spring.belajarspringio.service.implementasi;

import com.bagas.belajar.spring.belajarspringio.dao.FakultasDao;
import com.bagas.belajar.spring.belajarspringio.entity.Fakultas;
import com.bagas.belajar.spring.belajarspringio.service.FakultasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakultasServiceImpl implements FakultasService {

    @Autowired
    private FakultasDao fakultasDao;

    @Override
    public Fakultas save (Fakultas param) {
        return fakultasDao.save(param);

    }
    @Override
    public Fakultas update(Fakultas param){

        return  fakultasDao.update(param);
    }

    @Override
    public String delete(Fakultas param){

        return fakultasDao.delete(param);
    }

    @Override
    public List<Fakultas> find(){

        return fakultasDao.find();
    }

    @Override
    public Fakultas findByKd_Fakultas(String kd_fakultas) {
        return fakultasDao.findByKd_fakultas(kd_fakultas);
    }


}
