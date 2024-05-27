package com.coapatap.api.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "areas")
@Getter
@Setter
@NoArgsConstructor
public class AreasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idareas", nullable = false)
    private Integer idAreas;

    @Column(name = "name", nullable = false, length = 200)
    private String nombreArea;

    @Column(name = "superior_area")
    private Integer superiorArea;
}
