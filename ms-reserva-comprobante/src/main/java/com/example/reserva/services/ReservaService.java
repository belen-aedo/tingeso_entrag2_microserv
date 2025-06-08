package org.example.reserva.services;

import lombok.RequiredArgsConstructor;
import org.example.reserva.entities.ComprobanteEntity;
import org.example.reserva.entities.ReservaEntity;
import org.example.reserva.models.ReservaRequest;
import org.example.reserva.repositories.ComprobanteRepository;
import org.example.reserva.repositories.ReservaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepo;
    private final ComprobanteRepository comprobanteRepo;

    public ComprobanteEntity registrarReserva(ReservaRequest request) {
        // Guardar reserva
        ReservaEntity reserva = new ReservaEntity();
        reserva.setRutCliente(request.getRutCliente());
        reserva.setDiaReserva(request.getDiaReserva());
        reserva.setHoraInicio(request.getHoraInicio());
        reserva.setHoraFin(request.getHoraFin());
        reserva.setTiempoReserva(request.getTiempoReserva());
        reserva.setAcompanantes(request.getAcompanantes());

        reserva = reservaRepo.save(reserva);

        // Calcular monto (fijo por ahora)
        BigDecimal base = BigDecimal.valueOf(25000);
        BigDecimal descuento = BigDecimal.valueOf(0.1); // luego vendrá de ms-desc-num-personas
        BigDecimal montoFinal = base.multiply(BigDecimal.ONE.subtract(descuento));
        BigDecimal conIva = montoFinal.multiply(BigDecimal.valueOf(1.19)).setScale(0, BigDecimal.ROUND_HALF_UP);

        ComprobanteEntity comprobante = new ComprobanteEntity();
        comprobante.setReservaId(reserva.getId());
        comprobante.setMontoBase(base);
        comprobante.setDescuentoAplicado(base.multiply(descuento));
        comprobante.setMontoFinal(montoFinal);
        comprobante.setMontoTotalConIva(conIva);

        return comprobanteRepo.save(comprobante);
    }

    public ComprobanteEntity getComprobante(Long id) {
        return comprobanteRepo.findByReservaId(id);
    }
}
