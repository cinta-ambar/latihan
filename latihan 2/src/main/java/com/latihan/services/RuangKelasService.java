package com.latihan.services;

import com.latihan.exception.NonExistentResourceException;
import com.latihan.model.entities.RuangKelas;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface RuangKelasService {

    void addRuangKelas(RuangKelas ruangKelasAdd);

    Map<String, Object> getRuangKelas(int pageNumber, int pageSize, String sort);

    Optional<RuangKelas> getRuangKelasById(UUID idRuangKelas)throws NonExistentResourceException;

    RuangKelas editRuangKelasById(RuangKelas ruangKelas)throws NonExistentResourceException;

    void deleteRuangKelasById(UUID idRuangKelas);
}
