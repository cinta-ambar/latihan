package com.codeanapp.project.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ExampUpdateDto {

    @NotBlank(message = "id tidak boleh kosong")
    private String oldidexamp;

    @NotBlank(message = "id tidak boleh kosong")
    private String stackid;

    private String soal;
    private String keterangan;
}
