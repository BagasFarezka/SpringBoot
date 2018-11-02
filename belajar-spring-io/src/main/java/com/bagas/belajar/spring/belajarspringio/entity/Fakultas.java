package com.bagas.belajar.spring.belajarspringio.entity;

import java.io.Serializable;

public class Fakultas implements Serializable {

    private String kd_fakultas;
    private String nama_fakultas;
    private String jumlah_fakultas;

    public Fakultas(String kd_fakultas){

    }

    public String getKd_fakultas() {
        return kd_fakultas;
    }

    public void setKd_fakultas(String kd_fakultas) {
        this.kd_fakultas = kd_fakultas;
    }

    public String getNama_fakultas() {
        return nama_fakultas;
    }

    public void setNama_fakultas(String nama_fakultas) {
        this.nama_fakultas = nama_fakultas;
    }

    public String getJumlah_fakultas() {
        return jumlah_fakultas;
    }

    public void setJumlah_fakultas(String jumlah_fakultas) {
        this.jumlah_fakultas = jumlah_fakultas;
    }

    @Override
    public String toString(){
        return "Fakultas{" +
                "kd_fakultas=" + kd_fakultas +
                ", nama_fakultas='" + nama_fakultas +
                ", jumlah_fakultas='" + jumlah_fakultas + '\'' +
                '}';
    }
}
