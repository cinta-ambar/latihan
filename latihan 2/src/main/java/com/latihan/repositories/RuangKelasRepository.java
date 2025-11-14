package com.latihan.repositories;

import com.latihan.model.entities.RuangKelas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RuangKelasRepository extends JpaRepository<RuangKelas, UUID> {

    RuangKelas getById(UUID idRuangKelas);

    void deleteById(UUID idRuangKelas);
}
