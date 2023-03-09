package com.espe.concesionario.models;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "empleado")
@Getter
@Setter
@NoArgsConstructor
public class EmpleadoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_empleado;
    private String nombre;
    private String apellido;
    private String cargo;
    private String salario;
    private LocalDate fecha_contrato;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "empleado_id")
    private Set<VentasModel> ventasModels = new HashSet<>();

    public EmpleadoModel (Long empleado_id){
    }

    /*@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "empleado_id")
    private Set<ReparacionModel> reparacionModels = new HashSet<>();*/

}
