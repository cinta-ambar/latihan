package com.latihan.dtos.kursus;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
public class KursusPostDto {

    @NotBlank(message = "nama Kursus wajib diisi")
    private String namaKursus;
    @NotBlank(message = "level wajib diisi")
    private String level;
    private UUID idGuru;
    private UUID idRuangKelas;
    @NotNull(message = "number wajib diisi")
    private Integer number;

}
