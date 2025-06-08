package org.example.reportes.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ReporteIngresoDTO {
    private String criterio;
    private String valor;
    private BigDecimal total;
}
