package com.student.studentcrud.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.student.studentcrud.model.JurusanModel;
import com.student.studentcrud.model.MahasiswaModel;
import com.student.studentcrud.service.JurusanService;
import com.student.studentcrud.service.MahasiswaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MahasiswaController {

    @Autowired
    MahasiswaService mahasiswaService;

    @Autowired
    JurusanService jurusanService;

    // Route untuk ke home.html
    @RequestMapping("/mahasiswa")
    public String home() {
        return "/mahasiswa/home";
    }
    // Route to add.html
    @RequestMapping("mahasiswa/add")
    public String add(Model model) {
        this.bacaJurusan(model);
        return "/mahasiswa/add";
    }

    // Jurusan model
    public void bacaJurusan(Model model) {
        List<JurusanModel> jurusanModels = new ArrayList<>();
        jurusanModels = this.jurusanService.rJurusanModels();

        model.addAttribute("lemparJurusan", jurusanModels);
    }

    // Route insert to Database
    @RequestMapping("mahasiswa/insert")
    public String insert(HttpServletRequest request) { //parameter HttpSR berfungsi untuk request name dari FE
        String kodeMahasiswa = request.getParameter("kodeMahasiswa");
        String namaMahasiswa = request.getParameter("namaMahasiswa");
        String jenisKelamin = request.getParameter("jk");
        String alamat = request.getParameter("alamat");
        String status = request.getParameter("status");
        String kdJurusan = request.getParameter("nmJurusan");

        MahasiswaModel mahasiswaModel = new MahasiswaModel(); //di instance untuk memasukan value yang sudah di request ke modelmahasiswa / memanipulasi data di dalam modelmahasiswa
        mahasiswaModel.setKd_mhs(kodeMahasiswa);
        mahasiswaModel.setNm_mhs(namaMahasiswa);
        mahasiswaModel.setJk(jenisKelamin);
        mahasiswaModel.setAlamat(alamat);
        mahasiswaModel.setStatus(status);
        mahasiswaModel.setKdJurusan(kdJurusan);

        this.mahasiswaService.save(mahasiswaModel); // ngambil fungsi save yang ada di mahasiswaservice untuk action nya

        return "/mahasiswa/home";
    }
    // Route untuk nampilin isi data yang telah di insert ke FE
    @RequestMapping("/mahasiswa/list")
    public String lihat(Model model){ //sebagai pembungkus data yang di isi di variabel untuk di kirim ke FE

        List<MahasiswaModel> mahasiswaModelList ; //intance untuk mengambil semua data yang ada di dalam table mahasiswa / memanipulasi data dalam modelmahasiswa
        mahasiswaModelList = this.mahasiswaService.bacaDataMahasiswaTabel(); //setelah di intance variable yang sudah di intance tsb di isi kan fungsi bacasemua data yang ada di mahasiswaservice 

        model.addAttribute("listData", mahasiswaModelList); // variable mahasiswaModellist di bungkus atau di bundle di dalam pfungsi parameter model untuk di kirim ke FE
        return "/mahasiswa/list";
    }
    //Route untuk ke edit.html
    @RequestMapping("/mahasiswa/edit")
    public String edit(HttpServletRequest request, Model model){
        String kodeMahasiswa = request.getParameter("kdMhsEdit"); //request ngambil parameter yang di buat di ajax yg mana akan mencari primary key mana yang akan di edit 

        MahasiswaModel mahasiswaModel = new MahasiswaModel(); //intance mahasiswamodel untuk memanipulasi data mahasiswamodel
        mahasiswaModel = this.mahasiswaService.keyMhsTabel(kodeMahasiswa); //variable mahasiswa model di isi dengan fungsi mahasiswa servis yaitu yg sudah di custom di repo guna mencari primary key di mahasiswamodel

        model.addAttribute("editMhs", mahasiswaModel);//model untuk membungkus/mmbundle var mahasiswamodel dalam adddatribut dengan nama variable baru untuk di kirim ke FE

        return "/mahasiswa/edit";
    }
    //route untuk action tombol inputan/insert to database 
    //sama dengan line 32 sampai 49
    @RequestMapping("/mahasiswa/update")
    public String updateEdit(HttpServletRequest request){
        String kdMahasiswaEdit = request.getParameter("kodeMahasiswa");
        String nmMahasiswaEdit = request.getParameter("namaMahasiswa");
        String jkEdit = request.getParameter("jk");
        String alamatEdit = request.getParameter("alamat");
        String statusEdit = request.getParameter("status");
        String kdJurusan = request.getParameter("nmJurusan");

        MahasiswaModel mahasiswaModel = new MahasiswaModel();

        mahasiswaModel.setKd_mhs(kdMahasiswaEdit);
        mahasiswaModel.setNm_mhs(nmMahasiswaEdit);
        mahasiswaModel.setJk(jkEdit);
        mahasiswaModel.setAlamat(alamatEdit);
        mahasiswaModel.setStatus(statusEdit);
        mahasiswaModel.setKdJurusan(kdJurusan);

        this.mahasiswaService.updateData(mahasiswaModel);

        return "/mahasiswa/home";
    }
    // Route untuk ke romove.html penjelasan nya sama dengan line 62 - 71
    @RequestMapping("/mahasiswa/remove")
    public String hapus(HttpServletRequest request, Model model){
        String kodeMahasiswa = request.getParameter("kdMhsHapus");

        MahasiswaModel mahasiswaModel = new MahasiswaModel();
        mahasiswaModel = this.mahasiswaService.keyMhsTabel(kodeMahasiswa);

        model.addAttribute("lemparHapus", mahasiswaModel);

        return "/mahasiswa/remove";
    }
    // Route action hapus penejelasan sama dengan 32 -49
    @RequestMapping("/mahasiswa/hapus")
    public String hapusDataMhs(HttpServletRequest request){
        String kdMahasiswaHps = request.getParameter("kodeMahasiswa");
        String nmMahasiswaHps = request.getParameter("namaMahasiswa");
        String jkHps = request.getParameter("jk");
        String alamatHps = request.getParameter("alamat");
        String statusHps = request.getParameter("status");
        String kdJurusan = request.getParameter("nmJurusan");

        MahasiswaModel mahasiswaModel = new MahasiswaModel();
        mahasiswaModel.setKd_mhs(kdMahasiswaHps);
        mahasiswaModel.setNm_mhs(nmMahasiswaHps);
        mahasiswaModel.setJk(jkHps);
        mahasiswaModel.setAlamat(alamatHps);
        mahasiswaModel.setStatus(statusHps);
        mahasiswaModel.setKdJurusan(kdJurusan);

        this.mahasiswaService.hapus(mahasiswaModel); // gunakan fungsi yg ada di jpa repository yang sudah di buat di service 

        return "/mahasiswa/home";
    }


}
