package com.codeanapp.project.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PelajarUpdateDto {
    @NotBlank(message = "id tidak boleh kosong")
    private String oldidpelajar;

    @NotBlank(message = "nama tidak boleh kosong")
    private String namalengkap;

    @NotBlank(message = "nomer wa tidak boleh kosong")
    private String nowa;

    @NotBlank(message = "gender tidak boleh kosong")
    private String jeniskelamin;

    @NotBlank(message = "nama sekolah tidak boleh kosong")
    private String namasekolah;

    @NotBlank(message = "jurusan tidak boleh kosong")
    private String jurusan;

    @NotBlank(message = "pengetahuan koding tidak boleh kosong")
    private String pengetahuankoding;
}
