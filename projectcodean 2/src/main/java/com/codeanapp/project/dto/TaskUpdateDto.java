package com.codeanapp.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskUpdateDto {
    @NotBlank(message = "id tidak boleh kosong")
    private String oldidtask;

    @NotBlank(message = "id tidak boleh kosong")
    private String stackid;

    @NotBlank(message = "id tidak boleh kosong")
    private String pengajarid;

    private String soal;
    private String deskripsi;
}
