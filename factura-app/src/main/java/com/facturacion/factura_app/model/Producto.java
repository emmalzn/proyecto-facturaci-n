package com.facturacion.factura_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 320, nullable = false)
    private String nombre;

    @Column(length = 500)
    private String descripcion;

    @Column(nullable = false)
    private Double precio;

    @Column(name = "iva", nullable = false)
    private Double iva;

    @Column(name = "codigo_producto", length = 64)
    private String codigoProducto;

    // Aquí puedes agregar relaciones si el producto pertenece a una categoría, impuesto, etc.
}

