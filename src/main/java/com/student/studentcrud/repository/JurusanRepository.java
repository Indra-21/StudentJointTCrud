package com.student.studentcrud.repository;

import com.student.studentcrud.model.JurusanModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JurusanRepository extends JpaRepository<JurusanModel, String> {
    
}
