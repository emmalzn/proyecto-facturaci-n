package com.facturacion.factura_app.repository;

import com.facturacion.factura_app.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
