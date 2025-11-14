package com.latihan.dtos.kursus;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class MulaiKursusPostDto {
    private UUID idSiswa;
    private UUID idKursus;
    private String statusPendaftaran;
}
