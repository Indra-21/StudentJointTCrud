package com.student.studentcrud.repository;

import com.student.studentcrud.model.JurusanModel;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;

public interface JurusanRepository extends JpaRepository<JurusanModel, String> {
    // @Query("select t from MahasiswaModel t where kdJurusan = ?1")
    // JurusanModel cariTest(String kdJurusan); 
}
