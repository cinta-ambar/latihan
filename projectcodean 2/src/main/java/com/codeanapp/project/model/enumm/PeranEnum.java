package com.codeanapp.project.model.enumm;

public enum PeranEnum {

    SISWA_("siswa"),
    PENGAJAR_("pengajar");

    private final String message;

    PeranEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
