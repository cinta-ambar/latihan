package com.latihan.dtos.kursus;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class KursusSiswaDto {
    private UUID idSiswa;
    private UUID idKursus;
    private String jadwal;


}
