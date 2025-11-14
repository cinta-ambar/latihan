package com.codeanapp.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    private String idtask;
    private String stackid;
    private String pengajarid;
    private String soal;
    private String deskripsi;

}
