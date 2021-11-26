package com.student.studentcrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JurusanTabel")
public class JurusanModel {

    @Id
    @Column(name="kd_jurusan")
    private String kdJurusan;
    @Column(name="nm_jurusan")
    private String nmJurusan;
    
    public String getKdJurusan() {
        return kdJurusan;
    }
    public void setKdJurusan(String kdJurusan) {
        this.kdJurusan = kdJurusan;
    }
    public String getNmJurusan() {
        return nmJurusan;
    }
    public void setNmJurusan(String nmJurusan) {
        this.nmJurusan = nmJurusan;
    }

    

    
}
