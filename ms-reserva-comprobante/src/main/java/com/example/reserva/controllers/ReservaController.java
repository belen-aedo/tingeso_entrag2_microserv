package com.example.reserva.controllers;

import lombok.RequiredArgsConstructor;
import org.example.reserva.entities.ComprobanteEntity;
import org.example.reserva.models.ReservaRequest;
import org.example.reserva.services.ReservaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService service;

    @PostMapping
    public ComprobanteEntity crearReserva(@RequestBody ReservaRequest request) {
        return service.registrarReserva(request);
    }

    @GetMapping("/{id}/comprobante")
    public ComprobanteEntity obtenerComprobante(@PathVariable Long id) {
        return service.getComprobante(id);
    }
}
