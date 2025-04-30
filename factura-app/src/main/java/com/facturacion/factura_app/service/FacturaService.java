package com.facturacion.factura_app.service;

import com.facturacion.factura_app.model.Factura;
import com.facturacion.factura_app.repository.FacturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService {

    private final FacturaRepository facturaRepository;

    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    public List<Factura> getAllFacturas() {
        return facturaRepository.findAll();
    }

    public Optional<Factura> getFacturaById(Long id) {
        return facturaRepository.findById(id);
    }

    public Factura createFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    public Factura updateFactura(Long id, Factura facturaDetails) {
        return facturaRepository.findById(id)
                .map(factura -> {
                    factura.setFecha(facturaDetails.getFecha());
                    factura.setFechaVencimiento(facturaDetails.getFechaVencimiento());
                    factura.setFechaEnvioDian(facturaDetails.getFechaEnvioDian());
                    factura.setTotalImpuesto(facturaDetails.getTotalImpuesto());
                    factura.setTotalFinal(facturaDetails.getTotalFinal());
                    factura.setTotalDescuento(facturaDetails.getTotalDescuento());
                    factura.setStatusDian(facturaDetails.getStatusDian());
                    factura.setTipoDocumento(facturaDetails.getTipoDocumento());
                    factura.setTipoFactura(facturaDetails.getTipoFactura());
                    factura.setDocumentoOrigen(facturaDetails.getDocumentoOrigen());
                    factura.setNumeroFactura(facturaDetails.getNumeroFactura());
                    factura.setCUFE(facturaDetails.getCUFE());
                    factura.setObservaciones(facturaDetails.getObservaciones());
                    factura.setCliente(facturaDetails.getCliente());
                    factura.setProducto(facturaDetails.getProducto());
                    factura.setFormaPagoId(facturaDetails.getFormaPagoId());
                    factura.setTerminoId(facturaDetails.getTerminoId());
                    factura.setDivisaId(facturaDetails.getDivisaId());
                    factura.setImpuestoId(facturaDetails.getImpuestoId());
                    return facturaRepository.save(factura);
                })
                .orElseThrow(() -> new RuntimeException("Factura no encontrada con id: " + id));
    }

    public void deleteFactura(Long id) {
        facturaRepository.deleteById(id);
    }
}

