package org.example.racksemanal.services;

import lombok.RequiredArgsConstructor;
import org.example.racksemanal.models.OcupacionDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RackService {

    // Simulación de horarios por día (8:00 a 20:00 en bloques de 1h)
    public List<OcupacionDTO> obtenerRackSemana(LocalDate desde) {
        List<OcupacionDTO> semana = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            LocalDate dia = desde.plusDays(i);
            for (int h = 8; h < 20; h++) {
                LocalTime inicio = LocalTime.of(h, 0);
                LocalTime fin = inicio.plusHours(1);
                boolean ocupado = Math.random() < 0.3; // simular ocupación

                semana.add(new OcupacionDTO(dia, inicio, fin, ocupado));
            }
        }

        return semana;
    }
}
