package org.example.tarifas.repositories;

import org.example.tarifas.entities.TarifaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifaRepository extends JpaRepository<TarifaEntity, Long> {
    // JpaRepository ya incluye todos los métodos CRUD necesarios:
    // - findAll() -> List<TarifaEntity>
    // - findById(Long id) -> Optional<TarifaEntity>
    // - save(TarifaEntity entity) -> TarifaEntity
    // - deleteById(Long id) -> void
    // - count() -> long
    // - existsById(Long id) -> boolean

    // Aquí puedes agregar métodos personalizados si los necesitas
}