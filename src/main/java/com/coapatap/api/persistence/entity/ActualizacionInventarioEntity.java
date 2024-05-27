package com.coapatap.api.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "actualizaciones_inventario_inf")
@Getter
@Setter
@NoArgsConstructor
public class ActualizacionInventarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idactualizaciones_inventario_inf", nullable = false)
    private Integer idActualizacionInventario;

    @Column(name = "original_data", columnDefinition = "text", nullable = false)
    private String originalData;

    @Column(name = "new_data", columnDefinition = "text", nullable = false)
    private String newData;

    @Column(name = "fecha",columnDefinition = "timestamp", nullable = false)
    private LocalDateTime fechaActualizacionInventario;

    @Column(name = "user_id", nullable = false, length = 45)
    private String userId;

    @Column(name = "id_equipo",nullable = false)
    private Integer IdInventarioFor;

    //RELACION A INVENTARIO
    @ManyToOne
    @JoinColumn(name = "id_equipo", referencedColumnName = "idinventario_informatica", insertable = false, updatable = false)
    private InventarioEntity inventarioEntity;

}
