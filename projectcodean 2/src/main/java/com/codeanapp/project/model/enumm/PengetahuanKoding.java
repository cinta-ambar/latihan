package com.codeanapp.project.model.enumm;

public enum PengetahuanKoding {

    NOL_("pengetahuan nol"),
    SEDANG_("pengetahuan sedang"),
    EKSPERT("pengetahuan ekspert");

    private final String message;

    PengetahuanKoding(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
