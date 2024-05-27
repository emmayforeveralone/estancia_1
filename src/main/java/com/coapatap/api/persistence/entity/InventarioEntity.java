package com.coapatap.api.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "inventario")
@Getter
@Setter
@NoArgsConstructor
public class InventarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idinventario_informatica", nullable = false)
    private Integer idInventario;

    @Column(name = "no_inventario", nullable = false, columnDefinition = "text")
    private String noInventario;

    @Column(name = "observaciones", nullable = false, columnDefinition = "text")
    private String observacionInventario;

    @Column(nullable = false, columnDefinition = "text")
    private String marca;

    //LLAVES FORANEAS
    @Column(name = "id_empleado", nullable = false)
    private Integer idEmpleadoFor;

    @Column(name = "area", nullable = false)
    private Integer idAreaFor;

    @Column(name = "direccion", nullable = false)
    private Integer idDireccioFor;

    @Column(name = "ubicacion_fisica", nullable = false)
    private Integer idUbicacionFisicaFor;

    @Column(name = "tipo_de_equipo", nullable = false)
    private Integer idTipoEquipoFor;

    @Column(name = "estado", nullable = false)
    private Integer idEstadoFor;

    //RELACION A LA TABLA EMPLEADDO
    @ManyToOne
    @JoinColumn(name = "id_empleado", referencedColumnName = "idemployee", insertable = false, updatable = false)
    private EmpleadosEntity empleadosEntity;

    //RELACION A LA TABLA AREA
    @ManyToOne
    @JoinColumn(name = "area", referencedColumnName = "idareas", insertable = false, updatable = false)
    private AreasEntity areasEntity;

    @ManyToOne
    @JoinColumn(name = "direccion", referencedColumnName = "idareas", insertable = false, updatable = false)
    private AreasEntity areasDireccionEntity;

    //RELACION A LA TABLLA UBICACION
    @ManyToOne
    @JoinColumn(name = "ubicacion_fisica", referencedColumnName = "idubicacion_fisica", insertable = false, updatable = false)
    private UbicacionFisicaEntity ubicacionFisicaEntity;

    //RELACION A LA TABLA TIPO DE EQUIPO

    @ManyToOne
    @JoinColumn(name = "tipo_de_equipo", referencedColumnName = "idtipo_de_equipo", insertable = false, updatable = false)
    private TipoDeEquipoEntity tipoDeEquipoEntity;

    //RELACION A LA TABLA ESTATUS
    @ManyToOne
    @JoinColumn(name = "estado", referencedColumnName = "idnew_table", insertable = false, updatable = false)
    private EstatusInventarioEntity statusEntity;
}
