package com.student.studentcrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Mahasiswa_Table")
public class MahasiswaModel {
    
    @Id
    private String kd_mhs;
    private String nm_mhs;
    private String jk;
    private String alamat;
    private String status;
    @Column(name="kd_jurusan")
    private String kdJurusan;

    @ManyToOne
    @JoinColumn(name="kd_jurusan", nullable = true, insertable = false, updatable = false)
    private JurusanModel jurusanModel;


    public String getKdJurusan() {
        return kdJurusan;
    }
    public void setKdJurusan(String kdJurusan) {
        this.kdJurusan = kdJurusan;
    }
    public JurusanModel getJurusanModel() {
        return jurusanModel;
    }
    public void setJurusanModel(JurusanModel jurusanModel) {
        this.jurusanModel = jurusanModel;
    }
    public String getKd_mhs() {
        return kd_mhs;
    }
    public void setKd_mhs(String kd_mhs) {
        this.kd_mhs = kd_mhs;
    }
    public String getNm_mhs() {
        return nm_mhs;
    }
    public void setNm_mhs(String nm_mhs) {
        this.nm_mhs = nm_mhs;
    }
    public String getJk() {
        return jk;
    }
    public void setJk(String jk) {
        this.jk = jk;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }


    

}
