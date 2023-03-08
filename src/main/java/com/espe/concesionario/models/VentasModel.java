package com.espe.concesionario.models;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ventas")
@Getter
@Setter
@NoArgsConstructor
public class VentasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venta;


    @Column(name = "cliente_id")
    Long clienteId;


    @Column(name = "empleado_id")
    Long empleadoId;

    @Column(name = "vehiculo_id")
    Long vehiculoId;

    private LocalDate fecha_compra;
    private float precio;
}
