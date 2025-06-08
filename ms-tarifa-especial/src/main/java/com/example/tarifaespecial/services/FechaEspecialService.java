package org.example.tarifaespecial.services;

import lombok.RequiredArgsConstructor;
import org.example.tarifaespecial.entities.FechaEspecialEntity;
import org.example.tarifaespecial.repositories.FechaEspecialRepository;
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
