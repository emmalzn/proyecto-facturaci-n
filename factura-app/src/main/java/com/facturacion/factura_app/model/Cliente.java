package com.facturacion.factura_app.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String correo;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String direccion;
    private Integer ciudadId;
    private Integer departamentoId;
    private Integer paisId;
    private Integer digitoVerificacion;
    private Integer obligacionId;
    private Integer codigoPostal;
}
