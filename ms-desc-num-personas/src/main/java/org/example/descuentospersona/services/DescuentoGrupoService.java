package org.example.descuentospersona.services;

import org.springframework.stereotype.Service;

@Service
public class DescuentoGrupoService {

    public double calcularDescuento(int cantidadPersonas) {
        if (cantidadPersonas >= 11 && cantidadPersonas <= 15) {
            return 0.30;
        } else if (cantidadPersonas >= 6) {
            return 0.20;
        } else if (cantidadPersonas >= 3) {
            return 0.10;
        } else {
            return 0.0;
        }
    }
}
