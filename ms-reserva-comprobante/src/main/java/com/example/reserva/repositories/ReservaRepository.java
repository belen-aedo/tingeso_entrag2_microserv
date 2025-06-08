package org.example.reserva.repositories;

import org.example.reserva.entities.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {

    // Buscar reservas por RUT del cliente
    List<ReservaEntity> findByRutCliente(String rutCliente);

    // Buscar reservas por fecha
    List<ReservaEntity> findByDiaReserva(LocalDate diaReserva);

    // Buscar reservas en un rango de fechas
    List<ReservaEntity> findByDiaReservaBetween(LocalDate fechaInicio, LocalDate fechaFin);

    // Buscar reservas por cliente y fecha
    List<ReservaEntity> findByRutClienteAndDiaReserva(String rutCliente, LocalDate diaReserva);

    // Verificar disponibilidad de horario
    @Query("SELECT r FROM ReservaEntity r WHERE r.diaReserva = :fecha " +
            "AND ((r.horaInicio <= :horaInicio AND r.horaFin > :horaInicio) " +
            "OR (r.horaInicio < :horaFin AND r.horaFin >= :horaFin) " +
            "OR (r.horaInicio >= :horaInicio AND r.horaFin <= :horaFin))")
    List<ReservaEntity> findReservasEnConflicto(@Param("fecha") LocalDate fecha,
                                                @Param("horaInicio") LocalTime horaInicio,
                                                @Param("horaFin") LocalTime horaFin);
}