package com.latihan.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "daftar_kursus")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DaftarKursus {

    @Id
    @Column(name = "id_daftar_kursus")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idDaftarKursus;
    @Column(name = "status")
    private String Status;
    @Column(name = "status_kursus")
    private String statusKursus;
    @Column(name = "keterangan_status")
    private String kateranganStatus;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kursus_id")
    private Kursus kursus;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "siswa_id")
    private Siswa siswa;

}
