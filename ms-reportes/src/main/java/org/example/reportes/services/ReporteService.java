package org.example.reportes.services;

import lombok.RequiredArgsConstructor;
import org.example.reportes.models.ComprobanteDTO;
import org.example.reportes.models.ReservaDTO;
import org.example.reportes.models.ReporteIngresoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ReporteService {

    private final RestTemplate restTemplate;

    @Value("${servicios.reservas.url}")
    private String reservasUrl;

    @Value("${servicios.comprobantes.url}")
    private String comprobantesUrl;

    public List<ReporteIngresoDTO> ingresosPorNumeroPersonas() {
        ReservaDTO[] reservas = restTemplate.getForObject(reservasUrl + "/reservas", ReservaDTO[].class);
        ComprobanteDTO[] comprobantes = restTemplate.getForObject(comprobantesUrl + "/comprobantes", ComprobanteDTO[].class);

        Map<Integer, BigDecimal> ingresosPorCantidad = new HashMap<>();

        if (reservas != null && comprobantes != null) {
            for (ReservaDTO r : reservas) {
                int cantidadPersonas = 1 + (r.getAcompanantes() != null ? r.getAcompanantes().size() : 0);

                ComprobanteDTO c = Arrays.stream(comprobantes)
                        .filter(cp -> cp.getReservaId().equals(r.getIdReserva()))
                        .findFirst()
                        .orElse(null);

                if (c != null) {
                    ingresosPorCantidad.merge(cantidadPersonas, c.getMontoTotalConIva(), BigDecimal::add);
                }
            }
        }

        List<ReporteIngresoDTO> reporte = new ArrayList<>();
        ingresosPorCantidad.forEach((k, v) ->
                reporte.add(new ReporteIngresoDTO("Cantidad de personas", String.valueOf(k), v))
        );
        return reporte;
    }

    public List<ReporteIngresoDTO> ingresosPorTiempoReserva() {
        ReservaDTO[] reservas = restTemplate.getForObject(reservasUrl + "/reservas", ReservaDTO[].class);
        ComprobanteDTO[] comprobantes = restTemplate.getForObject(comprobantesUrl + "/comprobantes", ComprobanteDTO[].class);

        Map<Integer, BigDecimal> ingresosPorTiempo = new HashMap<>();

        if (reservas != null && comprobantes != null) {
            for (ReservaDTO r : reservas) {
                int tiempo = r.getTiempoReserva();

                ComprobanteDTO c = Arrays.stream(comprobantes)
                        .filter(cp -> cp.getReservaId().equals(r.getIdReserva()))
                        .findFirst()
                        .orElse(null);

                if (c != null) {
                    ingresosPorTiempo.merge(tiempo, c.getMontoTotalConIva(), BigDecimal::add);
                }
            }
        }

        List<ReporteIngresoDTO> reporte = new ArrayList<>();
        ingresosPorTiempo.forEach((k, v) ->
                reporte.add(new ReporteIngresoDTO("Tiempo reserva (min)", String.valueOf(k), v))
        );
        return reporte;
    }
}
