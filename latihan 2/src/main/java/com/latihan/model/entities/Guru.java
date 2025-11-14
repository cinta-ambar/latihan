package com.latihan.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "guru")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Guru {
    @Id
    @Column(name = "id_guru")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idGuru;
    @Column(name = "nama_guru")
    private String namaGuru;
    @Column(name = "spesialisasi")
    private String spesialisasi;

    @OneToMany(mappedBy = "guru", fetch = FetchType.LAZY)
    private List<Kursus> kursusList = new ArrayList<>();

}
