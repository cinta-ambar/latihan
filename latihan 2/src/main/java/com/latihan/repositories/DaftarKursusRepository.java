package com.latihan.repositories;

import com.latihan.model.entities.DaftarKursus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DaftarKursusRepository extends JpaRepository<DaftarKursus, UUID> {

}
