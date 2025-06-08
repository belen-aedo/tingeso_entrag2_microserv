package org.example.reportes.controllers;

import lombok.RequiredArgsConstructor;
import org.example.reportes.models.ReporteIngresoDTO;
import org.example.reportes.services.ReporteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reportes")
@RequiredArgsConstructor
public class ReporteController {

    private final ReporteService service;

    @GetMapping("/por-personas")
    public List<ReporteIngresoDTO> porPersonas() {
        return service.ingresosPorNumeroPersonas();
    }

    @GetMapping("/por-tiempo")
    public List<ReporteIngresoDTO> porTiempo() {
        return service.ingresosPorTiempoReserva();
    }
}
