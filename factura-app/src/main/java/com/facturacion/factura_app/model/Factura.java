package com.facturacion.factura_app.model;


import com.facturacion.factura_app.model.DetalleFactura;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private LocalDate fechaVencimiento;
    private LocalDate fechaEnvioDian;

    private Double totalImpuesto;
    private Double totalFinal;
    private Double totalDescuento;

    private String statusDian; // POR ENVIAR, ENVIADO, RECHAZADO
    private String tipoDocumento; // FACTURA, NOTA DÉBITO, etc.
    private String tipoFactura; // FACTURA NACIONAL, EXPORTACIÓN
    private String documentoOrigen; // orden de pedido, etc.
    private String numeroFactura; // prefijo + número
    private String CUFE;
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<DetalleFactura> detalles;

    @Column(name = "forma_pago_id")
    private Long formaPagoId;

    @Column(name = "termino_id")
    private Long terminoId;

    @Column(name = "impuesto_id")
    private Long impuestoId;

    @Column(name = "divisa_id")
    private Long divisaId;
}


