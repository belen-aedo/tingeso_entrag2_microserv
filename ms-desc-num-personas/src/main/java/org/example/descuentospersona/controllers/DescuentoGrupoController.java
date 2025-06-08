package org.example.descuentospersona.controllers;

import lombok.RequiredArgsConstructor;
import org.example.descuentospersona.services.DescuentoGrupoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/descuento-grupo")
@RequiredArgsConstructor
public class DescuentoGrupoController {

    private final DescuentoGrupoService service;

    @GetMapping
    public double obtenerDescuento(@RequestParam int personas) {
        return service.calcularDescuento(personas);
    }
}
