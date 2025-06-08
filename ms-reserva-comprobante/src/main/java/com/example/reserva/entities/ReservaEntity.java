package org.example.reserva.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservas")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rutCliente;
    private LocalDate diaReserva;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private int tiempoReserva; // en minutos

    @ElementCollection
    private List<String> acompanantes;
}
