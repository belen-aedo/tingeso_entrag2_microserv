package org.example.reserva.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comprobantes")
public class ComprobanteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long reservaId;

    private BigDecimal montoBase;
    private BigDecimal descuentoAplicado;
    private BigDecimal montoFinal;
    private BigDecimal montoTotalConIva;
}
