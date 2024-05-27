package com.coapatap.api.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
public class EmpleadosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idemployee", nullable = false)
    private Integer idEmpleado;

    @Column(name = "name", nullable = false, length = 200)
    private String nombreEmpleado;

    @Column(name = "apellidoP", nullable = false, length = 100)
    private String apellidoPaterno;

    @Column(name = "apellidoM", nullable = false, length = 100)
    private String apellidoMaterno;

    @Column(name = "no_nomina", nullable = false, length = 100)
    private String noNomina;

    @Column(columnDefinition = "longtext")
    private String obervaciones;

    //LLAVES FORANEAS
    @Column(name = "area", nullable = false)
    private Integer idAreaFor;

    @Column(name = "sucursal_asignada", nullable = false)
    private Integer idSucursalFor;

    //RELACION A LA TABLA AREAS

    @ManyToOne
    @JoinColumn(name = "area", referencedColumnName = "idareas",insertable = false, updatable = false)
    private AreasEntity areasEntity;

    //RELACION A LA TABLA SUCURSAL
    @OneToOne
    @JoinColumn(name = "sucursal_asignada", referencedColumnName = "id", insertable = false, updatable = false)
    private SucursalEntity sucursalEntity;
}
