package com.latihan.services;

import com.latihan.model.entities.Siswa;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface SiswaService {

    void addSiswa(Siswa siswaAdd);

    Map<String, Object> getSiswa(int pageNumber, int pageSize, String sort);

    Optional<Siswa> getSiswaById(UUID idSiswa);

    Siswa editSiswaById(Siswa siswa);

    void deleteSiswaById(UUID idSiswa);
}
