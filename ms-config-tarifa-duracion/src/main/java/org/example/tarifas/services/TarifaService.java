package org.example.tarifas.services;

import org.example.tarifas.entities.TarifaEntity;
import org.example.tarifas.repositories.TarifaRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TarifaService {

    private final TarifaRepository repository;

    public List<TarifaEntity> listarTarifas() {
        return repository.findAll();
    }

    public Optional<TarifaEntity> obtenerTarifa(Long id) {
        return repository.findById(id);
    }

    public TarifaEntity crearTarifa(TarifaEntity tarifa) {
        return repository.save(tarifa);
    }

    public void eliminarTarifa(Long id) {
        repository.deleteById(id);
    }
}