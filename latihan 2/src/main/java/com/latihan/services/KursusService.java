package com.latihan.services;


import com.latihan.dtos.kursus.KursusPostDto;
import com.latihan.dtos.kursus.KursusResponseDto;
import com.latihan.model.entities.Kursus;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface KursusService {
    void addKursus(KursusPostDto kursusAdd);

    Map<String, Object> getKursus(int pageNumber, int pageSize, String sort);

    Optional<Kursus> getKursusById(UUID idKursus);

    Kursus editKursusById(Kursus kursus);

    void deleteKursusById(UUID idKursus);
}
