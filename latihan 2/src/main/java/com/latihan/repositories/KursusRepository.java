package com.latihan.repositories;

import com.latihan.model.entities.Kursus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KursusRepository extends JpaRepository<Kursus, UUID> {

    Kursus getById(UUID idKursus);

    void deleteById(UUID idKursus);
}
