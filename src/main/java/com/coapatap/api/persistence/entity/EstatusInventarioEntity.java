package com.coapatap.api.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "estatus_inventario")
@Getter
@Setter
@NoArgsConstructor
public class EstatusInventarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idnew_table")
    private Integer idEstaoInventario;

    @Column(nullable = false, length = 100)
    private String estadoInventario;

    @Column(name = "descripcion",nullable = false)
    private String descripcionInventario;
}
