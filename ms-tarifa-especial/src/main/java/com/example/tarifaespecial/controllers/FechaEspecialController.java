package com.example.tarifaespecial.controllers;

import lombok.RequiredArgsConstructor;
import com.example.tarifaespecial.entities.FechaEspecialEntity; // CORREGIDO: cambiar org.example por com.example
import com.example.tarifaespecial.services.FechaEspecialService; // CORREGIDO: cambiar org.example por com.example
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarifa-especial")
@RequiredArgsConstructor
public class FechaEspecialController {

    private final FechaEspecialService service;

    @GetMapping
    public List<FechaEspecialEntity> listarFechas() {
        return service.listar();
    }

    @PostMapping
    public FechaEspecialEntity agregar(@RequestBody FechaEspecialEntity fecha) {
        return service.agregarFecha(fecha);
    }

    @GetMapping("/consultar")
    public Optional<FechaEspecialEntity> obtenerTarifa(@RequestParam String fecha) {
        return service.obtenerTarifaPorFecha(LocalDate.parse(fecha));
    }
}