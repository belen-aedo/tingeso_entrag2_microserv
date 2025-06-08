package org.example.tarifas.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tarifas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarifaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numeroVueltas;
    private int tiempoMaximo;     // en minutos
    private int precioBase;       // valor base
    private int duracionReserva;  // en minutos
}