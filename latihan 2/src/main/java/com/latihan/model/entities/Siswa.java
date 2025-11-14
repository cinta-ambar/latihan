package com.latihan.model.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "siswa")
public class Siswa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_siswa")
    private UUID idSiswa;
    @Column(name = "nama_siswa")
    private String namaSiswa;
    @Column(name = "batch")
    private String batch;


    @OneToMany(mappedBy = "siswa")
    private List<DaftarKursus> daftarKursusList = new ArrayList<>();


    public Siswa(){

    }

    public Siswa(UUID idSiswa, String namaSiswa, String batch) {
        this.idSiswa = idSiswa;
        this.namaSiswa = namaSiswa;
        this.batch = batch;
    }

    public UUID getIdSiswa() {
        return idSiswa;
    }

    public void setIdSiswa(UUID idSiswa) {
        this.idSiswa = idSiswa;
    }

    public String getNamaSiswa() {
        return namaSiswa;
    }

    public void setNamaSiswa(String namaSiswa) {
        this.namaSiswa = namaSiswa;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }


}
