package org.example.reserva.repositories;

import org.example.reserva.entities.ComprobanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ComprobanteRepository extends JpaRepository<ComprobanteEntity, Long> {

    // Buscar comprobantes por RUT del cliente
    List<ComprobanteEntity> findByRutCliente(String rutCliente);

    // Buscar comprobante por ID de reserva
    ComprobanteEntity findByReservaId(Long reservaId);

    // Buscar comprobantes por rango de fechas
    List<ComprobanteEntity> findByFechaEmisionBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    // Buscar comprobantes por cliente y fecha
    List<ComprobanteEntity> findByRutClienteAndFechaEmisionBetween(String rutCliente,
                                                                   LocalDateTime fechaInicio,
                                                                   LocalDateTime fechaFin);
}