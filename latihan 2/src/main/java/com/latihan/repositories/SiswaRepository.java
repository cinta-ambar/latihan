package com.latihan.repositories;

import com.latihan.model.entities.Siswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SiswaRepository extends JpaRepository<Siswa, UUID> {

    Siswa getById(UUID idSiswa);

    void deleteById(UUID idSiswa);

    List<Siswa> findByNamaSiswaContainingIgnoreCaseOrBatchContainingIgnoreCase(String search1, String search2);
}
