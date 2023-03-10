package com.espe.concesionario.controllers;

import com.espe.concesionario.models.VehiculoModel;
import com.espe.concesionario.services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehiculo")
@CrossOrigin(origins = "http://localhost:4200")
public class VehiculoController {
    @Autowired
    VehiculoService vehiculoService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<VehiculoModel> listarVehiculos(){
        return vehiculoService.listarVehiculos();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public VehiculoModel crearVehiculo(@RequestBody VehiculoModel vehiculoModel){
        return vehiculoService.crearVehiculo(vehiculoModel);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/{id}")
    public Optional<VehiculoModel> vehiculoPorId(@PathVariable(value = "id") Long vehiculoId) {
        return vehiculoService.vehiculoPorId(vehiculoId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VehiculoModel actualizarVehiculo(@RequestBody VehiculoModel vehiculoBody, @PathVariable Long id){
        return vehiculoService.actualizarVehiculo(vehiculoBody, id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarVehiculo(@PathVariable Long id){
        vehiculoService.eliminarVehiculo(id);
    }



    /*@CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public void eliminarAutomovil(@PathVariable long id){
        automovilService.eliminarAutomovil(id);
    }*/

}
