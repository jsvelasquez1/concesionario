package com.espe.concesionario.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;
    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private String telefono;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Set<VentasModel> ventasModels = new HashSet<>();

    public ClienteModel(Long id_cliente, String nombre, String apellido, String cedula, String direccion, String telefono, Set<VentasModel> ventasModels) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ventasModels = ventasModels;
    }

    public ClienteModel(Long cliente_id) {
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<VentasModel> getVentasModels() {
        return ventasModels;
    }

    public void setVentasModels(Set<VentasModel> ventasModels) {
        this.ventasModels = ventasModels;
    }
}
