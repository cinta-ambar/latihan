package com.latihan.dtos.kursus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.latihan.model.entities.Guru;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
public class KursusResponseDto {

    private UUID idKursus;
    private String namaKursus;
    private String level;
    private Guru guru;
}
