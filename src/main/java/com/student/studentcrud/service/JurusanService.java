package com.student.studentcrud.service;

import java.util.List;

import com.student.studentcrud.model.JurusanModel;
import com.student.studentcrud.repository.JurusanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JurusanService {

    @Autowired
    private JurusanRepository jurusanRepository;

    public List<JurusanModel> rJurusanModels(){
        return this.jurusanRepository.findAll();
    }

    public void saveJurusan(JurusanModel jurusanModel) {
        this.jurusanRepository.save(jurusanModel);
    }

    
}
