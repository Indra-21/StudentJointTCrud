package com.student.studentcrud.repository;

import com.student.studentcrud.model.MahasiswaModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MahasiswaRepository extends JpaRepository<MahasiswaModel, String> {
    // custom untuk melakukan pencarian primary key 
    @Query("select p from MahasiswaModel p where kd_mhs = ?1")
    MahasiswaModel carikodemhs(String kd_mhs);

    // @Query("select t from MahasiswaModel t where kdJurusan = ?1")
    // MahasiswaModel cariTest(String kdJurusan);
    // @Query("select j from MahasiswaModel j where kd_mhs =?1 and kdJurusan =?2")
    // MahasiswaModel carijurusan(String kd_mhs, String kdJurusan);
    
}
