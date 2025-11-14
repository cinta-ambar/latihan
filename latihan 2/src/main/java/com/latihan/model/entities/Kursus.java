package com.latihan.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "kursus")
public class Kursus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_kursus")
    private UUID idKursus;
    @Column(name = "nama_kursus")
    private String namaKursus;
    @Column(name = "level")
    private String level;
    @Column(name = "status_pendaftaran")
    private String statusPendaftaran;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guru_id")
    private Guru guru;

    @OneToOne
    @JoinColumn(name = "ruang_kelas_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RuangKelas ruangKelas;

    @OneToMany(mappedBy = "kursus")
    private List<DaftarKursus> daftarKursusList = new ArrayList<>();

    public Kursus(){

    }

    public Kursus(UUID idKursus, String namaKursus, String level, String statusPendaftaran) {
        this.idKursus = idKursus;
        this.namaKursus = namaKursus;
        this.level = level;
        this.statusPendaftaran = statusPendaftaran;
    }

}
