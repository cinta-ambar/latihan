package com.latihan.model.responses;

public enum StatusKursus {
    TERDAFTAR("sudah terdaftar"),
    BELUM_TERDAFTAR("belum terdaftar"),
    BELUM_TERDAFTAR_KURSUS("silakan mendaftar terlebih dahulu"),
    TERDAFTAR_DIKELAS_BAHASAINDONESIA("terdaftar di kelas bhs. indonesia"),
    TERDAFTAR_DIKELAS_KIMIAFARMASI("terdaftar di kelas kimia farmasi"),
    TERDAFTAR_DIKELAS_MATEMATIKAFISIKA("terdaftar di kelas matematika fisika"),
    TERDAFTAR_DIKELAS_ANATOMITUBUH("terdaftar di kelas anatomi tubuh"),
    TERDAFTAR_DIKELAS_BAHASAINGGRIS("terdaftar dikelas bahasa inggris"),
    MASA_KURSUS("dalam masa kursus"),
    SELESAI("sudah selesai kursus");

    private final String message;

    StatusKursus(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
