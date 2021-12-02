package com.student.studentcrud.service;

import java.util.List;

import com.student.studentcrud.model.MahasiswaModel;
import com.student.studentcrud.repository.MahasiswaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MahasiswaService {
    
    @Autowired
    MahasiswaRepository mahasiswaRepository;
    

    // @Transactional(readOnly = true)
    // untuk melakukan insert ke db
    public void save(MahasiswaModel mahasiswa) {
        mahasiswaRepository.save(mahasiswa);
    }
    // untuk membaca semua daya yang ada di table mahasiswa model jika Fe request ke be
    public List<MahasiswaModel> bacaDataMahasiswaTabel(){
        return this.mahasiswaRepository.findAll();
    }
    // fungsi yang sama dengan save 
    // public void updateData(MahasiswaModel mahasiswaUpdate){
    //     mahasiswaRepository.save(mahasiswaUpdate);
    // }
    // untuk mengambil primarykey yang add di table mahasiswamodel 
    // jika dari fe req melakukan update suatu data dengan mengirimkan value yang mau di update
    // ke be dari be akan melakukan update dengan mencari primari key yang di minta fe
    // dan di kirimkan kembali kee fe untuk di lakukan perubahan
    // untuk mencari primary key sendiri perlu custom terlebih dahulu di sisi repository
    // agar bisa di gunakan ke service
    public MahasiswaModel keyMhsTabel(String kd_mhs){
        return this.mahasiswaRepository.carikodemhs(kd_mhs);
    }

    // public MahasiswaModel cariJurusanMhs(String kd_mhs, String kdJurusan){
    //     return this.mahasiswaRepository.carijurusan(kd_mhs, kdJurusan);
    // }
    // public MahasiswaModel test(String kdJurusan){
    //     return this.mahasiswaRepository.cariTest(kdJurusan);
    // }

    // untuk melakukan perintah hapus data yang ada di mahasiswamodel
    public void hapus(MahasiswaModel mahasiswaHapus){
        mahasiswaRepository.delete(mahasiswaHapus);
    }
}
