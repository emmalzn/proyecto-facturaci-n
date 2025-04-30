package com.facturacion.factura_app.service;

import com.facturacion.factura_app.model.DetalleFactura;
import com.facturacion.factura_app.repository.DetalleFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleFacturaService {

    @Autowired
    private DetalleFacturaRepository repository;

    public List<DetalleFactura> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<DetalleFactura> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public DetalleFactura guardar(DetalleFactura detalle) {
        return repository.save(detalle);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

