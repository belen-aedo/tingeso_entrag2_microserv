package org.example.descfrecuente.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


import java.time.LocalDate;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity {

    @Id
    private String rut;
    private String nombre;
    private String email;
    private int visitasMes;
    private LocalDate fechaCumple;
    private int descuentoAplicable;
}
