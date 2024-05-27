package com.coapatap.api.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ubicacion_fisica")
@Getter
@Setter
@NoArgsConstructor
public class UbicacionFisicaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idubicacion_fisica", nullable = false)
    private Integer idUbicacionFisica;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombreUbicacionFisica;

    @Column(name = "descripcion", nullable = false)
    private String descripcionUbicacionFisica;

    @Column(name = "sucursal", nullable = false)
    private Integer idSucursalFor;

    //RELACION A LA TABLA SUCURSAL
    @OneToOne
    @JoinColumn(name = "sucursal", referencedColumnName = "id",insertable = false, updatable = false)
    private SucursalEntity sucursal;
}
