package com.codeanapp.project.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class MateriUpdateDto {

    @NotBlank(message = "id tidak boleh kosong")
    private String oldidmateri;

    @NotBlank(message = "id tidak boleh kosong")
    private String stackid;

    private String judulmateri;
    private String deskripsimateri;
}
