package org.example.reserva.models;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class ReservaRequest {
    private String rutCliente;
    private LocalDate diaReserva;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private int tiempoReserva;
    private List<String> acompanantes;
}
