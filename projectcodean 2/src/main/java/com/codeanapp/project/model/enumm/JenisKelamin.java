package com.codeanapp.project.model.enumm;

public enum JenisKelamin {
    PRIA_("laki-laki"),
    WANITA_("perempuan");

    private final String message;

    JenisKelamin(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
