package com.latihan.services;

import com.latihan.model.entities.Guru;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface GuruService {
    void addGuru(Guru guruAdd);

    Map<String, Object> getGuru(int pageNumber, int pageSize, String sort);

    Optional<Guru> getGuruById(UUID idGuru);

    Guru editGuruById(Guru guru);

    void deleteGuruById(UUID idGuru);

}
