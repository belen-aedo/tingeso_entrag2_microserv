package org.example.reportes.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ComprobanteDTO {
    private Long id;
    private Long reservaId;
    private BigDecimal montoFinal;
    private BigDecimal montoTotalConIva;
}
