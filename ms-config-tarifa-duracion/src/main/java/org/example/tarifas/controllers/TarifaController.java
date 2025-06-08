package org.example.tarifas.controllers;

import lombok.RequiredArgsConstructor;
import org.example.tarifas.entities.TarifaEntity;
import org.example.tarifas.services.TarifaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarifas")
@RequiredArgsConstructor
public class TarifaController {

    private final TarifaService service;

    @GetMapping
    public List<TarifaEntity> listar() {
        return service.listarTarifas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarifaEntity> obtener(@PathVariable Long id) {
        return service.obtenerTarifa(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TarifaEntity crear(@RequestBody TarifaEntity tarifa) {
        return service.crearTarifa(tarifa);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminarTarifa(id);
    }
}
