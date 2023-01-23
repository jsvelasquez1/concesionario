package com.espe.concesionario.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "proveedor")
@Getter
@Setter
@NoArgsConstructor
public class ProveedorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proveedor;
    private String nombre;
    private String direccion;
    private String num_telefono;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "proveedor_id")
    @JsonIgnore
    private Set<VehiculoModel> vehiculoModels = new HashSet<>();
}
