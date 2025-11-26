package com.codeanapp.project.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
public class Barang {


    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String idBarang;

    @NotBlank(message = "ID Header tidak boleh kosong.")
    @Size(max = 255)
    private String idHeader;

    @NotNull(message = "Seri barang tidak boleh kosong.")
    private BigDecimal seriBarang;

    @NotBlank(message = "Nama barang tidak boleh kosong.")
    @Size(max = 255)
    private String namaBarang;

    @NotBlank(message = "Kode barang tidak boleh kosong.")
    @Size(max = 255)
    private String kodeBarang;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String jenisBarang;

    @Size(max = 255)
    private String nibBarang;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String nipRekam;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Jakarta")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Timestamp waktuRekam;
}
