package org.example.tarifaespecial.repositories;

import org.example.tarifaespecial.entities.FechaEspecialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.Optional;



@Repository
public interface FechaEspecialRepository extends JpaRepository<FechaEspecialEntity, Long> {
    Optional<FechaEspecialEntity> findByFecha(LocalDate fecha);
}
