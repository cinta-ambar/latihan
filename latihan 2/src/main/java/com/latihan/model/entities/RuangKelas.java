package com.latihan.model.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "ruang_kelas")
public class RuangKelas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ruang_kelas")
    private UUID idRuangKelas;
    @Column(name = "nama_kelas")
    private String namaKelas;
    @Column(name = "kapasitas")
    private Integer kapasitas;
    @Column(name = "jadwal")
    private String jadwal;

    @OneToOne(mappedBy = "ruangKelas")
    private Kursus kursus;

    public RuangKelas(){

    }

    public RuangKelas(UUID idRuangKelas, String namaKelas, Integer kapasitas, String jadwal) {
        this.idRuangKelas = idRuangKelas;
        this.namaKelas = namaKelas;
        this.kapasitas = kapasitas;
        this.jadwal = jadwal;
    }

    public UUID getIdRuangKelas() {
        return idRuangKelas;
    }

    public void setIdRuangKelas(UUID idRuangKelas) {
        this.idRuangKelas = idRuangKelas;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public Integer getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(Integer kapasitas) {
        this.kapasitas = kapasitas;
    }

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }
}
