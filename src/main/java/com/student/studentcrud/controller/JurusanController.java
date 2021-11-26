// package com.student.studentcrud.controller;

// import java.util.ArrayList;
// import java.util.List;

// import com.student.studentcrud.model.JurusanModel;
// import com.student.studentcrud.service.JurusanService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.transaction.annotation.Transactional;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.RequestMapping;

// @Controller
// @Transactional
// public class JurusanController {
   
//     @Autowired
//     JurusanService jurusanService;

    
//     public void bacaJurusan(Model model) {
//         List<JurusanModel> jModels = new ArrayList<>();
//         jModels = this.jurusanService.rJurusanModels();

//         model.addAttribute("lemparJurusan", jModels);
//     }
// }
