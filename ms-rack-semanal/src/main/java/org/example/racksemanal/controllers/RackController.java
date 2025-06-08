package org.example.racksemanal.controllers;

import lombok.RequiredArgsConstructor;
import org.example.racksemanal.models.OcupacionDTO;
import org.example.racksemanal.services.RackService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/rack")
@RequiredArgsConstructor
public class RackController {

    private final RackService service;

    @GetMapping("/semana")
    public List<OcupacionDTO> verRack(@RequestParam String desde) {
        LocalDate inicio = LocalDate.parse(desde);
        return service.obtenerRackSemana(inicio);
    }
}
