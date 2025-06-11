package com.example.tarifaespecial.repositories;

import com.example.tarifaespecial.entities.FechaEspecialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional; // AGREGADO: import faltante

@Repository
public interface FechaEspecialRepository extends JpaRepository<FechaEspecialEntity, Long> {
    Optional<FechaEspecialEntity> findByFecha(LocalDate fecha);
}