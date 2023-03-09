package com.espe.concesionario.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vehiculo")
@Getter
@Setter
@NoArgsConstructor
public class VehiculoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vehiculo;
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private String precio;
    @Column(name = "proveedor_id")
    Long proveedorId;

    /*@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "vehiculo_id")
    private Set<ReparacionModel> reparacionModels = new HashSet<>();*/

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "vehiculo_id")
    private Set<VentasModel> ventasModels = new HashSet<>();

    public VehiculoModel (Long vehiculo_id){
    }


}
