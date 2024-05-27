package com.coapatap.api.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tipo_de_equipo")
@Getter
@Setter
@NoArgsConstructor
public class TipoDeEquipoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipo_de_equipo", nullable = false)
    private Integer idTipoDeEquipo;

    @Column(name = "nombre",nullable = false)
    private String nombreTipoDeEquipo;

    @Column(name = "descripcion",length = 255)
    private String descripcionTipoDeEquipo;

}
