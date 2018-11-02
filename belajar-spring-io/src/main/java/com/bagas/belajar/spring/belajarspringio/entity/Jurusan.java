package com.bagas.belajar.spring.belajarspringio.entity;

import java.io.Serializable;

public class Jurusan implements Serializable {

    private int kd_jurusan;
    private int kd_fakultasFakultas;
    private String nama_jurusan;
    private Fakultas fakultas;//object join

    public Jurusan(String kd_jurusan){
        this.kd_jurusan= kd_fakultasFakultas;
    }

    public Jurusan(String id, String kd_fakultas){
        this.kd_jurusan =kd_jurusan ;
        this.kd_fakultas=kd_fakultas;
    }

    public Jurusan (String nama_jurusan){
        this.nama_jurusan = nama_jurusan;
    }

    public Jurusan() {
        this.kd_jurusan= kd_jurusan;
    }


    public int getId() {
        return kd_jurusan;
    }

    public void setId(String kd_jurusan) {
        this.kd_jurusan = kd_jurusan;
    }

    public int getIdFakultas() {
        return kd_jurusan;
    }

    public void setKd_fakultas(String Kd_fakultas) {
        this.Kd_fakultas = kd_fakultas;
    }
    //join
    public Fakultas getFakultas() {
        return fakultas;
    }

    public void setFakultas(Fakultas fakultas) {
        this.fakultas = fakultas;
    }
    //

    public String getNama_jurusan() {
        return nama_jurusan;
    }

    public void setNamajurusan(String nama_jurusan) {
        this.nama_jurusan = nama_jurusan;
    }



    @Override
    public String toString() {
        return "Jurusan{" +
                "kd_jurusan=" + kd_jurusan +
                ", nama_jurusan='" + nama_jurusan + '\'' +
                "kd_Fakultas='" + kd_fakultas +
                '}';
    }
}
