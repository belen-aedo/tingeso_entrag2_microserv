package com.example.tarifaespecial.services;

import lombok.RequiredArgsConstructor;
import com.example.tarifaespecial.entities.FechaEspecialEntity; // CORREGIDO: cambiar org.example por com.example
import com.example.tarifaespecial.repositories.FechaEspecialRepository; // CORREGIDO: cambiar org.example por com.example
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FechaEspecialService {

    private final FechaEspecialRepository repository;

    public List<FechaEspecialEntity> listar() {
        return repository.findAll();
    }

    public FechaEspecialEntity agregarFecha(FechaEspecialEntity fecha) {
        return repository.save(fecha);
    }

    public Optional<FechaEspecialEntity> obtenerTarifaPorFecha(LocalDate fecha) {
        return repository.findByFecha(fecha);
    }
}