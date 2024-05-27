package com.coapatap.api.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "componentes_inventario")
@Getter
@Setter
@NoArgsConstructor
public class ComponentesInventarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_componente", nullable = false)
    private Integer idComponenteInventario;

    @Column(nullable = false, length = 200)
    private String componenteInventario;

    @Column(nullable = false)
    private Integer tipo;

    @Column(name = "capacidad",nullable = false, length = 50)
    private String capacidadComponente;

    @Column(name = "marca",nullable = false, length = 200)
    private String marcaComponente;

    @Column(name = "id_equipo",nullable = false)
    private Integer IdInventarioFor;

    //RELACION A INVENTARIO

    @ManyToOne
    @JoinColumn(name = "id_equipo", referencedColumnName = "idinventario_informatica", insertable = false, updatable = false)
    private InventarioEntity inventarioEntity;

}
